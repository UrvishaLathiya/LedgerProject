package controller;

import com.google.gson.Gson;

import dao.LedgerDAO;
import model.Ledger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LedgerFilterController")
public class LedgerFilterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("getVersions".equals(action)) {
            try {
                List<Integer> apVersions = LedgerDAO.getApVersions();
                Gson gson = new Gson();
                response.getWriter().write(gson.toJson(apVersions));
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().write("[]");
            }
            return;
        }

        String ledgerName = request.getParameter("ledgerName");
        String groupName = request.getParameter("groupName");
        String subGroupName = request.getParameter("subGroupName");
        String apVersionStr = request.getParameter("apVersion");
        System.out.println("Received AP Version: " + apVersionStr);
        
        Integer apVersion = null;
        if (apVersionStr != null && !apVersionStr.isEmpty()) {
            try {
                apVersion = Integer.parseInt(apVersionStr);
            } catch (NumberFormatException e) {
                apVersion = null;
            }
        }

        if ("downloadCSV".equals(action)) {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=ledger_data.csv");
            try {
                List<Ledger> filteredLedgers = LedgerDAO.getAll(ledgerName, groupName, subGroupName, apVersion, 1, Integer.MAX_VALUE);
                StringBuilder csv = new StringBuilder();
                
                Field[] fields = Ledger.class.getDeclaredFields();
                
                // Writing Headers
                for (Field field : fields) {
                    csv.append(field.getName()).append(",");
                }
                csv.append("\n");

                // Writing Data 
                for (Ledger ledger : filteredLedgers) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        Object value = field.get(ledger);
                        csv.append(value != null ? value : "").append(",");
                    }
                    csv.append("\n");
                }
                
                response.getWriter().write(csv.toString());
            } catch (SQLException | IllegalAccessException e) {
                e.printStackTrace();
                response.getWriter().write("Error generating CSV");
            }
            return;
        }


        int pageNumber = 1;
        int pageSize = 50;
        String pageStr = request.getParameter("start");
        String lengthStr = request.getParameter("length");

        if (pageStr != null && !pageStr.isEmpty()) {
            try {
                pageNumber = (Integer.parseInt(pageStr) / pageSize) + 1;
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }
        }

        if (lengthStr != null && !lengthStr.isEmpty()) {
            try {
                pageSize = Integer.parseInt(lengthStr);
            } catch (NumberFormatException e) {
                pageSize = 100;
            }
        }

        try {
            int totalRecords = LedgerDAO.getTotalCount(null, null, null, null);
            int filteredRecords = LedgerDAO.getTotalCount(ledgerName, groupName, subGroupName, apVersion);
            List<Ledger> filteredLedgers = LedgerDAO.getAll(ledgerName, groupName, subGroupName, apVersion, pageNumber, pageSize);

            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("draw", request.getParameter("draw"));
            jsonResponse.put("recordsTotal", totalRecords);
            jsonResponse.put("recordsFiltered", filteredRecords);
            jsonResponse.put("data", filteredLedgers);

            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(jsonResponse));
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("{\"error\": \"An error occurred while fetching data.\"}");
        }
    }
}

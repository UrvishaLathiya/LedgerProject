package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LedgerDAO;
import model.Ledger;

@WebServlet("/LedgerFilterController")
public class LedgerFilterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ledgerName = request.getParameter("ledgerName");
        String groupName = request.getParameter("groupName");
        String subGroupName = request.getParameter("subGroupName");
        String apVersionStr = request.getParameter("apVersion");

        if (ledgerName != null) ledgerName = ledgerName.trim();
        if (groupName != null) groupName = groupName.trim();
        if (subGroupName != null) subGroupName = subGroupName.trim();

        Integer apVersion = null;
        if (apVersionStr != null && !apVersionStr.isEmpty()) {
            try {
                apVersion = Integer.parseInt(apVersionStr);
            } catch (NumberFormatException e) {
                apVersion = null;
            }
        }

        int pageNumber = 1;
        int pageSize = 20;
        String pageStr = request.getParameter("page");
        if (pageStr != null && !pageStr.isEmpty()) {
            try {
                pageNumber = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }
        }

        try {
            int totalRecords = LedgerDAO.getTotalCount(ledgerName, groupName, subGroupName, apVersion);
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
            List<Ledger> filteredLedgers = LedgerDAO.getAll(ledgerName, groupName, subGroupName, apVersion, pageNumber, pageSize);

            request.setAttribute("ledgerList", filteredLedgers);
            request.setAttribute("currentPage", pageNumber);
            request.setAttribute("totalPages", totalPages);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while fetching data.");
        }
    }
}

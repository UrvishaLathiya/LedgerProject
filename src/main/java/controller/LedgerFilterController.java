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
        // Get filter parameters from request
        String ledgerName = request.getParameter("ledgerName");
        String groupName = request.getParameter("groupName");
        String subGroupName = request.getParameter("subGroupName");
        
        if (ledgerName != null) ledgerName = ledgerName.trim();
        if (groupName != null) groupName = groupName.trim();
        if (subGroupName != null) subGroupName = subGroupName.trim();

        // Call DAO method to get filtered data
        List<Ledger> filteredLedgers = LedgerDAO.getFilteredLedgers(ledgerName, groupName, subGroupName);

        // Store filtered data in request scope
        request.setAttribute("ledgerList", filteredLedgers);

        // Forward request back to index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

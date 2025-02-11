<%@ page import="java.util.List, model.Ledger, dao.LedgerDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ledger Records</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Ledger Records</h2>

        <%
            LedgerDAO ledgerDAO = new LedgerDAO();
            List<Ledger> ledgerList = ledgerDAO.getAll();
        %>

        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>IDD</th>
                        <th>Ledger Name</th>
                        <th>Group ID</th>
                        <th>Group Name</th>
                        <th>Sub Group ID</th>
       					<th>Sub Group Name</th> 
                        <th>Is Ledger</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Ledger ledger : ledgerList) { %>
                        <tr>
                            <td><%= ledger.getId() %></td>
                            <td><%= ledger.getLedgerName() %></td>
                            <td><%= ledger.getGroupId() %></td>
                            <td><%= ledger.getGroupName() != null ? ledger.getGroupName() : "-" %></td>
                            <td><%= ledger.getSubGroupId() %></td>
            				<td><%= ledger.getSubGroupName() != null ? ledger.getSubGroupName() : "-" %></td>
                            <td><%= ledger.getIsLedger() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>

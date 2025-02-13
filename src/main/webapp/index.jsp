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
        <h2 class="text-center">Ledger Records</h2><br><br>
        
        <form method="get" action="LedgerFilterController" class="d-flex align-items-center">
		    <input type="text" name="ledgerName" class="form-control me-2" placeholder="Enter Ledger Name">
		    <input type="text" name="groupName" class="form-control me-2" placeholder="Enter Group Name">
		    <input type="text" name="subGroupName" class="form-control me-2" placeholder="Enter Sub Group Name">
		    <button type="submit" class="btn btn-primary">Search</button>
		</form><br><br>
        

        <%
            List<Ledger> ledgerList = (List<Ledger>) request.getAttribute("ledgerList");
            if (ledgerList == null) {
                LedgerDAO ledgerDAO = new LedgerDAO();
                ledgerList = ledgerDAO.getAll(); 
            }
        %>

        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-primary">
                    <tr>
                        <th>ID</th>
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
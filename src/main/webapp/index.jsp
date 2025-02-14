<%@ page import="java.util.List, model.Ledger, dao.LedgerDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ledger Records</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Ledger Records</h2><br><br>
        
         <form method="get" action="LedgerFilterController" class="d-flex align-items-center">
		    Ledger: <input type="text" name="ledgerName" class="form-control me-2" placeholder="Enter Ledger Name">
		    Group: <input type="text" name="groupName" class="form-control me-2" placeholder="Enter Group Name">
		    Sub Group: <input type="text" name="subGroupName" class="form-control me-2" placeholder="Enter Sub Group Name">
		    APVersion: <input type="text" name="apVersion" class="form-control me-2" placeholder="Enter APversion Name">
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
                        <th>Created Date</th>
                        <th>Updated Date</th>
                        <th>Version</th>
                        <th>Code</th>
                        <th>Is Group</th>
                        <th>Is Sub Group</th>
                        <th>Created By</th>
                        <th>Updated By</th>
                        <th>Ledger Type ID</th>
                        <th>Parent ID</th>
                        <th>TB Menu ID</th>
                        <th>Serial Number</th>
                        <th>Formula</th>
                        <th>Is Editable</th>
                        <th>Depreciation Ledger ID</th>
                        <th>Accumulated Depreciation ID</th>
                        <th>Is Optional</th>
                        <th>AP Version</th>
                        <th>FSA Area ID</th>
                        <th>Ledger Header</th>
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
                            <td><%= ledger.getCreatedDate() %></td>
                            <td><%= ledger.getUpdatedDate() %></td>
                            <td><%= ledger.getVersion() %></td>
                            <td><%= ledger.getCode() %></td>
                            <td><%= ledger.getIsGroup() %></td>
                            <td><%= ledger.getIsSubGroup() %></td>
                            <td><%= ledger.getCreatedBy() %></td>
                            <td><%= ledger.getUpdatedBy() %></td>
                            <td><%= ledger.getLedgerTypeId() %></td>
                            <td><%= ledger.getParentId() %></td>
                            <td><%= ledger.getTbMenuId() %></td>
                            <td><%= ledger.getSerialNumber() %></td>
                            <td><%= ledger.getFormula() %></td>
                            <td><%= ledger.getIsEditable() %></td>
                            <td><%= ledger.getDepreciationLedgerId() %></td>
                            <td><%= ledger.getAccumulatedDepreciationId() %></td>
                            <td><%= ledger.isOptional() %></td>
                            <td><%= ledger.getApVersion() %></td>
                            <td><%= ledger.getFsaAreaId() %></td>
                            <td><%= ledger.getLedgerHeader() %></td>
                            
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
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

        <!-- Fetch data from DAO directly -->
        <%
            LedgerDAO ledgerDAO = new LedgerDAO();
            List<Ledger> ledgerList = ledgerDAO.getAll();
        %>

        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Ledger Name</th>
                        <th>Group Name</th>
       					<th>Sub Group Name</th> 
                        <th>Is Active</th>
                        <th>Is Deleted</th>
                        <th>Version</th>
                        <th>Code</th>
                        <th>Is Group</th>
                        <th>Is Ledger</th>
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
                            <td><%= ledger.getGroupName() != null ? ledger.getGroupName() : "-" %></td>
            				<td><%= ledger.getSubGroupName() != null ? ledger.getSubGroupName() : "-" %></td> 
                            <td><%= ledger.isActive() %></td>
                            <td><%= ledger.isDeleted() %></td>
                            <td><%= ledger.getVersion() %></td>
                            <td><%= ledger.getCode() %></td>
                            <td><%= ledger.getIsGroup() %></td>
                            <td><%= ledger.getIsLedger() %></td>
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

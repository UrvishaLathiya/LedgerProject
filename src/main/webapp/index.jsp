<%@ page import="java.util.List, model.Ledger, dao.LedgerDAO" %>
<%
    if (request.getAttribute("ledgerList") == null) {
        response.sendRedirect("LedgerFilterController?page=1");
    }
%>


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
            <label for="apVersion" class="form-label">AP Version:</label>
<select name="apVersion" id="apVersion" class="form-select">
    <option value="">Select AP Version</option>
    <%
        List<Integer> apversions = (List<Integer>) request.getAttribute("apVersions");
        if (apversions != null) {
            for (Integer version : apversions) { %>
                <option value="<%= version %>"><%= version %></option>
            <% }
        }
    %>
</select>

	        <button type="submit" class="btn btn-primary">Search</button>
        </form><br><br>        

        <%
            List<Ledger> ledgerList = (List<Ledger>) request.getAttribute("ledgerList");
            Integer currentPage = (Integer) request.getAttribute("currentPage");
            Integer totalPages = (Integer) request.getAttribute("totalPages");
            if (currentPage == null) currentPage = 1;
            if (totalPages == null) totalPages = 1;
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
                    <% if (ledgerList != null && !ledgerList.isEmpty()) { %>
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
                    <% } else { %>
                        <tr><td colspan="27" class="text-center">No records found.</td></tr>
                    <% } %>
                </tbody>
            </table>

            <div class="d-flex justify-content-between">
                <% if (currentPage > 1) { %>
                    <a href="?page=<%= currentPage - 1 %>" class="btn btn-secondary">Previous</a>
                <% } else { %>
                    <button class="btn btn-secondary" disabled>Previous</button>
                <% } %>
                
                <span>Page <%= currentPage %> of <%= totalPages %></span>
                
                <% if (currentPage < totalPages) { %>
                    <a href="?page=<%= currentPage + 1 %>" class="btn btn-secondary">Next</a>
                <% } else { %>
                    <button class="btn btn-secondary" disabled>Next</button>
                <% } %>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>

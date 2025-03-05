<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ledger Table</title>
    <link rel="stylesheet" href="css/ledgerStyle.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4" align="center">Ledger Records</h2>
    
    <div class="toast-container position-fixed top-0 end-0 p-3">
	    <div id="successToast" class="toast align-items-center text-white bg-success border-0" role="alert" aria-live="polite" aria-atomic="true">
	        <div class="d-flex">
	            <div class="toast-body">
	                CSV Downloaded Successfully
	            </div>
	            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
	        </div>
	    </div>
	</div>
	
	<button id="downloadBtn" class="btn btn-primary mb-3">
	     Download CSV
	</button>


    
    <div class="row mb-3">
        <div class="col-md-3">
            <input type="text" id="ledgerName" class="form-control" placeholder="Search Ledger Name">
        </div>
        <div class="col-md-3">
            <input type="text" id="groupName" class="form-control" placeholder="Search Group Name">
        </div>
        <div class="col-md-3">
            <input type="text" id="subGroupName" class="form-control" placeholder="Search Sub Group Name">
        </div>
        <div class="col-md-3">
            <select id="apVersion" class="form-control"></select>
        </div>
    </div>

    
    <table id="ledgerTable" class="table table-bordered table-striped">
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
                <th>Is Group</th>
                <th>Is Sub Group</th>
                <th>Created By</th>
                <th>Updated By</th>
                <th>Ledger Type ID</th>
                <th>Parent ID</th>
                <th>TB Menu ID</th>
                <th>Serial Number</th>
                <th>Is Editable</th>
                <th>Depreciation Ledger ID</th>
                <th>Accumulated Depreciation ID</th>
                <th>Is Optional</th>
                <th>AP Version</th>
                <th>FSA Area ID</th>
                <th>Ledger Header</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<!-- Bootstrap & jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>

<script src="js/ledger.js"></script>


</body>
</html>

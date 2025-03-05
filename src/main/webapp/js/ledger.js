$(document).ready(function () {
    let table = $('#ledgerTable').DataTable({
        "processing": true,
        "serverSide": true,
        "scrollX": true,
        "paging": true,
        "pageLength": 50,
        
        "ajax": {
            "url": "LedgerFilterController",
            "type": "GET",
            "data": function (d) {
                d.ledgerName = $('#ledgerName').val() || "";
                d.groupName = $('#groupName').val() || "";
                d.subGroupName = $('#subGroupName').val() || "";
                d.apVersion = $('#apVersion').val() || "";
            },
            "dataSrc": function (json) {
                return json.data;
            },
        },
        "columns": [
            { "data": "id" },
            { "data": "ledgerName" },
            { "data": "groupId" },
            { "data": "groupName" },
            { "data": "subGroupId" },
            { "data": "subGroupName" },
            { "data": "isLedger" },
            { "data": "createdDate" },
            { "data": "updatedDate" },
            { "data": "version" },
            { "data": "isGroup" },
            { "data": "isSubGroup" },
            { "data": "createdBy" },
            { "data": "updatedBy" },
            { "data": "ledgerTypeId" },
            { "data": "parentId" },
            { "data": "tbMenuId" },
            { "data": "serialNumber" },
            { "data": "isEditable" },
            { "data": "depreciationLedgerId" },
            { "data": "accumulatedDepreciationId" },
            { "data": "isOptional" },
            { "data": "apVersion" },
            { "data": "fsaAreaId" },
            { "data": "ledgerHeader" }
        ]
    });

    $.ajax({
        url: "LedgerFilterController",
        type: "GET",
        data: { action: "getVersions" },
        dataType: "json",
        success: function (data) {
            var dropdown = $("#apVersion");
            dropdown.empty();
            dropdown.append('<option value="">Select AP Version</option>');
            $.each(data, function (index, value) {
                dropdown.append('<option value="' + value + '">' + value + '</option>');
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching AP Versions: " + error);
        }
    });

    $('#ledgerName, #groupName, #subGroupName, #apVersion').on('keyup change', function () {
        table.draw();
    });

    document.getElementById("downloadBtn").addEventListener("click", function () {
        let btn = this;
        let spinner = document.createElement("div");
        spinner.className = "spinner";
        btn.appendChild(spinner);
        spinner.style.display = "inline-block";

        let ledgerName = $('#ledgerName').val() || "";
        let groupName = $('#groupName').val() || "";
        let subGroupName = $('#subGroupName').val() || "";
        let apVersion = $('#apVersion').val() || "";

        if (!ledgerName && !groupName && !subGroupName && !apVersion) {
            alert("Please apply at least one filter before downloading.");
            spinner.remove();
            return;
        }

        let columnNames = [];
        table.columns().every(function () {
            let header = this.header();
            columnNames.push($(header).text().trim());
        });

        let url = "LedgerFilterController?action=downloadCSV";
        url += "&ledgerName=" + encodeURIComponent(ledgerName);
        url += "&groupName=" + encodeURIComponent(groupName);
        url += "&subGroupName=" + encodeURIComponent(subGroupName);
        url += "&apVersion=" + encodeURIComponent(apVersion);
        url += "&columns=" + encodeURIComponent(JSON.stringify(columnNames));

        window.location.href = url;

        setTimeout(() => {
            spinner.remove();
            showToast();
        }, 3000);
    });

    function showToast() {
        let toastElement = document.getElementById("successToast");
        let toast = new bootstrap.Toast(toastElement);
        toast.show();
    }
});

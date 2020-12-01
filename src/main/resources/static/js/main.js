let branchTable = "/allBranches";
let deleteButton = "/delete/";
let addButton = "/add";

$("#branches").click(function () {
    getBranchesTable();
});

function getBranchesTable() {
    $("#branchesList").empty();
    $.ajax({
        type: 'GET',
        url: branchTable,
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, branch) {
                $('#branchesList').append($('<tr>').append(
                    $('<td>').text(branch.id),
                    $('<td>').text(branch.name),
                    $('<td>').text(branch.inn),
                    $('<td>').text(branch.kpp),
                    $('<td>').text(branch.ogrn),
                    $('<td>').text(branch.address),
                    $('<td>').append($('<button><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-archive-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">\n' +
                        '  <path fill-rule="evenodd" d="M12.643 15C13.979 15 15 13.845 15 12.5V5H1v7.5C1 13.845 2.021 15 3.357 15h9.286zM6 7a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1H6zM.8 1a.8.8 0 0 0-.8.8V3a.8.8 0 0 0 .8.8h14.4A.8.8 0 0 0 16 3V1.8a.8.8 0 0 0-.8-.8H.8z"/>\n' +
                        '</svg></button>').attr({
                        "type": "button",
                        "class": "delete",
                        "data-toggle": "modal",
                        "data-target": "#deleteModal",
                    }).data("branch", branch))
                ))
            });
        }
    });
}

//Add Modal Window
$(document).on("click", ".add", function () {
    $("#newBranch").trigger('click');
});

$(document).on("click", ".addNew", function () {
    $("#branchesTable").trigger('click');

    let newBranchForm = {

        name: $("#newName").val(),
        inn: $("#newInn").val(),
        kpp: $("#newKpp").val(),
        ogrn: $("#newOgrn").val(),
        address: $("#newAddress").val()

    };
    $.ajax({
        type: 'POST',
        url: addButton,
        dataType: 'json',
        contentType: 'application/JSON; charset=utf-8',
        data: JSON.stringify(newBranchForm),
        success: function () {
            $('form[id=newBranch]').trigger('reset');
            getBranchesTable();
        }
    });
});


//DeleteBranch
$(document).on("click", ".delete", function () {
    let delBranch = $(this).data('branch');

    $("#delId").val(delBranch.id);
    $("#delName").val(delBranch.name);

});

//DeleteButtonBranch
$(document).on("click", ".deleteButton", function () {
    let id = $("#delId").val();
    $.ajax({
        method: 'DELETE',
        url: deleteButton + id,
        contentType: "application/json",
        dataType: "json",
        success: getBranchesTable()
    });
});
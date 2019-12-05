$(document).ready(function () {

    $("#addclient-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {

    var sex = document.getElementById("sex");
    var resource = document.getElementById("resource");

    var _data = {};
    _data["secondName"] = $("#secondName").val();
    _data["firstName"] = $("#firstName").val();
    _data["thirdName"] = $("#thirdName").val();
    _data["email"] = $("#email").val();
    _data["phone"] = $("#phone").val();
    _data["dateOfBirth"] = $("#date".toString()).val();
    _data["sex"] = sex.options[sex.selectedIndex].value;
    _data["resource"] = resource.options[resource.selectedIndex].value;

    $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/addNewClient",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Клієнта додано! </h4>";
            var na = $('<a/>');
            na.attr('href', "./client?id=" + data.msg);
            na.text('Перейти на профіль клієнта');
            na.addClass('btn btn-info');
            $('#profile').append(na);
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);

        },
        error: function (e) {
            var json = "<h4>Помилка!</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);

        }
    });

}

$("a#delete").click(function(){
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["id"] = $text;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/delete/client",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "";
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = e.responseText;
            $('#result').html(json);
            $("a#clickview").hide();
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });

});

$(document).ready(function () {
    $('#datetimepicker3').datetimepicker({locale: 'uk', format: 'L', viewMode: 'years'});
});

$(document).ready(function () {
    $('#clientsBasicTable').DataTable();
    $('.dataTables_length').addClass('bs-select');
});

$("a#getSingleClient").click(function(){
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["clientId"] = $text;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/client",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("SUCCESS : ", e);
        }
    });

});


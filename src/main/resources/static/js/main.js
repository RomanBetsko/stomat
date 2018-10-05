
$(document).ready(function () {

    $("#addbook-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {

    var _data = {};
    _data["name"] = $("#name").val();
    _data["description"] = $("#description").val();
    _data["price"] = $("#price").val();
    _data["yearOfPublication"] = $("#date".toString()).val();
    _data["author"] = $("#author").val();

    $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/add",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Book was added, check your card!</h4>";
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);

        },
        error: function (e) {
            var json = "<h4>Ajax Response error</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);

        }
    });

}

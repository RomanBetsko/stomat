$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/informSize",
        //data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            $('#notification').html(data.msg);
            // alert(data.msg);
        },
        error: function (e) {
            alert(data);
            alert('bbbbb');
        }
    });
});




$("button#clientsToInform").click(function(){

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/getClientsToInform",
        data: JSON.stringify(null),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Book was added, check your card!</h4>";
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = "<h4>Ajax Response security</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);

            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);

        }
    });

});
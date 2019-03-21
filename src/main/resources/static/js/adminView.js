$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/getClientsToInform",
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




$("a#clientsToInform").click(function(e){
    
    alert('something');
    
    
    e.preventDefault();
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["bookId"] = $text;

    //todo refactor when will added multiusers
    _data["readerId"] = 1;
    $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/addBookToCard",
        data: JSON.stringify(_data),
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
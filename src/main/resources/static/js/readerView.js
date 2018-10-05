
$(document).ready(function () {

    $("#addbook-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

$("a#click").click(function(e){
    e.preventDefault();
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();
    
    var _data = {};
    _data["bookId"] = $text;
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

        },
        error: function (e) {

            var json = "<h4>Ajax Response error</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);

            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);

        }
    });

});

function fire_ajax_submit() {
        var $row = $(this).closest("tr"); 
        var $text = $row.find(".id").text();

    
}

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

function fire_ajax_submit() {
        var $row = $(this).closest("tr"); 
        var $text = $row.find(".id").text();

    
}


$("a#orderCardView").click(function(e){
    e.preventDefault();

    var _data = {};
    //todo refactor when will added multiusers
    _data["customerId"] = 1;
    $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/getOrderCard",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "";
            //$('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = e.responseText;
            $('#result').html(json);
            $('#overlay').fadeIn(400,
                function(){ 
                    $('#modal_form')
                        .css('display', 'block')
                        .animate({opacity: 1, top: '21%', left: '75%'}, 100);
                });
            $('#modal_close, #overlay').click( function(){
                $('#modal_form')
                    .animate({opacity: 0, top: '45%'}, 200,
                        function(){ // пoсле aнимaции
                            $(this).css('display', 'none');
                            $('#overlay').fadeOut(400);
                        }
                    );
            });
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });

});

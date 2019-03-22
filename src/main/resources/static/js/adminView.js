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
//todo refactor (on error)
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/getClientsToInform",
        cache: false,
        timeout: 600000,
        success: function (data) {

            $('#notificationresult').html(data);
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


        },
        error: function (e) {

            var json = e.responseText;
            $('#notificationresult').html(json);
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


$("a#delete").click(function(){
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["id"] = $text;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/deleteClientFromInform",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            location.reload();

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

});
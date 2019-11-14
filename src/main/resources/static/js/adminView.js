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

$("button#clientsToInform").click(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/getClientsToInform",
        cache: true,
        timeout: 600000,
        success: function (data) {

            $('#notificationresult').html(data);
            $('#overlay').fadeIn(400, function () {

                $('#modal-warning').css('display', 'block');

                $("a#deleteFromInform").click(function () {
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
            });
            $('#modal_close, #overlay').click(function () {
                $('#modal-warning').css('display', 'none');
                $('#overlay').fadeOut(400, function () {
                });
            });
            $('#modal-warning').click(function () {
                $('#modal-warning').css('display', 'none');
                $('#overlay').fadeOut(400, function () {
                });
            });
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

});


$("a#openNav").click(function () {
    if (document.getElementById("mySidebar").style.display == "block") {
        close();
    } else {
        document.getElementById("mySidebar").style.width = "17%";
        document.getElementById("mySidebar").style.marginLeft = "-30px";
        document.getElementById("mySidebar").style.zIndex = "999999";
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("mySidebar").style.overflow = "hidden";
        document.getElementById("myOverlay").style.display = "block";
        document.getElementById("myOverlay").style.zIndex = "999998";
    }
});

function close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("openNav").style.display = "inline-block";
    document.getElementById("myOverlay").style.display = "none";
}


$("div#myOverlay").click(function () {
    document.getElementById("myOverlay").style.display = "none";
    document.getElementById("mySidebar").style.display = "none";
});

$("a#goBack").click(function goBack() {
    window.history.back();
});

$("a#goForward").click(function goBack() {
    window.history.forward();
});
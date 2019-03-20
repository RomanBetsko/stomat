$("a#createapp").click(function(){

    var _data = {};
    _data["clientId"] = $(this).data("clientid");
    _data["firstName"] = $(this).data("firstname");
    _data["secondName"] = $(this).data("secondname");
    _data["thirdName"] = $(this).data("thirdname");

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/appointment",
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

$("a#delete").click(function(){
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["id"] = $text;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/delete/appointment",
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
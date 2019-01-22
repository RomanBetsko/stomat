
$(document).ready(function () {

    $("#addbook-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {

    var arrr = $('input[name="field_name[]"]').each(function() { var aValue = $(this).val(); });
    var x = $('input[name="field_name[]"]').val();
    var asd = $("#author").val();


    var _data = {};
    _data["secondName"] = $("#secondName").val();
    _data["firstName"] = $("#firstName").val();
    _data["thirdName"] = $("#thirdName").val();
    _data["email"] = $("#email").val();
    _data["phone"] = $("#phone").val();
    _data["dateOfBirth"] = $("#date".toString()).val();
    _data["sex"] = $("#sex").val();
    // _data["addedBy"] = 1;
    // _data["authors"]= [];

    // var elems = [] ;
    // elems = $( "[name^='field_name']" ).each(function() {
    //     _data["authors"].push($(this).val());
    // });

    $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/addNewClient",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Клієнта додано!</h4>";
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);

        },
        error: function (e) {
            var json = "<h4>Ajax Response security</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);

        }
    });

}

$("a#clickview").click(function(e){
    e.preventDefault();

    var _data = {};
    //todo refactor when will added multiusers
    _data["customerId"] = 1;
        $("#btn-add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "customer/delete",
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


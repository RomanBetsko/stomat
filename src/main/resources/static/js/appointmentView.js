// $("a#procedureView").click(function () {
// });

$(document).ready(function () {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    today = mm + '.' + dd + '.' + yyyy;
    $('#datetimepicker3').datetimepicker({locale: 'uk'});
    $('#datetimepicker3').data("DateTimePicker").minDate(moment(today, 'DD.MM.YYYY'));
});

$(document).ready(function () {
    $("#datetimepicker4").click(function () {
        var dateFrom = $('#datetimepicker3').data("DateTimePicker").date();
        $('#datetimepicker4').datetimepicker({locale: 'uk'});
        $('#datetimepicker4').data("DateTimePicker").minDate(moment(dateFrom, 'DD.MM.YYYY'));
    });
});


$(document).ready(function () {
    document.getElementById("bth-add").onclick = function () {
        functionCreate()
    };
    // $("#addclient-form").submit(function (event) {
    //     event.preventDefault();
    //     fire_ajax_submit();
    // });
});


$("a#procedureView").click(function(e){
    var maxField = 20;
    var addButton = $('.add_button');
    var wrapper = $('.field_wrapper');
    var fieldHTML = '<div></div>';

    var _data = {};
    //todo дістати реальні дані
    _data["customerId"] = 1;
    _data["appointmentId"] = 1;


    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/procedure/create",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "";
            // $('#result').html(json);
            $(fieldHTML).append(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = e.responseText;
            // $('#result').html(json);

            $('#result').append(json);
            // $("a#clickview").hide();
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });

    var x = 1;
    $(addButton).click(function () {
        if (x < maxField) {
            x++;
            $(wrapper).append(fieldHTML);
        }
    });
    $(wrapper).on('click', '.remove_button', function () {
        $(this).parent('div').remove();
        x--;
    });
});

function functionCreate() {
    var _data = {};
    _data["name"] = $("#name").val();
    _data["clientId"] = $("#clientId").data("clientid");
    _data["description"] = $("#description").val();
    _data["dateFrom"] = $("#dateFrom".toString()).val();
    _data["dateTo"] = $("#dateTo".toString()).val();
    
    _data["procedure"] = [];


    var elems = [] ;
    elems = $( "[id^='procedureName']" ).each(function() {
        _data["procedure"].push({name: $(this).val(), price: ''});
    });


    elems = $( "[id^='procedurePrice']" ).each(function(index) {
        { _data.procedure[index].price = $(this).val() }
    });

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/appointment/create",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "";
            // $('#result').html(json);
            $(fieldHTML).append(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = e.responseText;
            // $('#result').html(json);

            $('#result').append(json);
            // $("a#clickview").hide();
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });


    alert(JSON.stringify(_data));
}



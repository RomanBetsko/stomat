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
    var dateTimeIntervals = document.getElementById("disabledDates").innerHTML;
    var b = JSON.parse(dateTimeIntervals).map(function (item) {
        return [moment(item.dateFrom), moment(item.dateTo)];
    });
        today = dd + '.' + mm + '.' + yyyy;
    $('#datetimepicker3').datetimepicker({
        locale: 'uk',
        disabledHours: [0, 1, 2, 3, 4, 5, 6, 7, 21, 22, 23],
        sideBySide: true,
        disabledTimeIntervals: b
    });
$('#datetimepicker3').data("DateTimePicker").minDate(moment(today, 'DD.MM.YYYY'));
})
;

$(document).ready(function () {
    var dateTimeIntervals = document.getElementById("disabledDates").innerHTML;
    var b = JSON.parse(dateTimeIntervals).map(function (item) {
        return [moment(item.dateFrom), moment(item.dateTo)];
    });
    $("#datetimepicker4").click(function () {
        var dateFrom = $('#datetimepicker3').data("DateTimePicker").date();
        $('#datetimepicker4').datetimepicker({
            locale: 'uk',
            disabledHours: [0, 1, 2, 3, 4, 5, 6, 7, 21, 22, 23],
            sideBySide: true,
            disabledTimeIntervals: b
        });
        $('#datetimepicker4').data("DateTimePicker").minDate(moment(dateFrom, 'DD.MM.YYYY'));
    });
});


$(document).ready(function () {
    document.getElementById("bth-add").onclick = function () {
        functionCreate()
    };
});

$(document).ready(function () {
    var maxField = 20;
    var addButton = $('.add_button');
    var wrapper = $('.field_wrapper');
    var fieldHTML = '<div></div>';

    var _data = {};
    //todo дістати реальні дані реальні процедури і тд.
    _data["customerId"] = 1;
    _data["appointmentId"] = 1;



    // $.ajax({
    //     type: "POST",
    //     contentType: "application/json",
    //     url: "/admin/procedure/create",
    //     data: JSON.stringify(_data),
    //     dataType: 'json',
    //     cache: false,
    //     timeout: 600000,
    //     success: function (data) {
    //         $(fieldHTML).append("");
    //         $("#btn-add").prop("disabled", false);
    //     },
    //     error: function (e) {
    //         console.log(e.responseText)
    //         var json = e.responseText;
    //         $('#result').append(json);
    //         console.log("ERROR : ", e);
    //         $("#btn-add").prop("disabled", false);
    //     }
    // });

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

    $("a#procedureView").click(function (e) {
        var _data = {};
        //todo дістати реальні дані реальні процедури і тд.
        _data["procedureId"] = 1;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/procedure/create",
            data: JSON.stringify(_data),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $(fieldHTML).append("");
                $("#btn-add").prop("disabled", false);
            },
            error: function (e) {
                console.log(e.responseText)
                var json = e.responseText;
                $('#result').append(json);
                console.log("ERROR : ", e);
                $("#btn-add").prop("disabled", false);
            }
        });
    });

    $('select').on('change', function () {
        var procedureName = this.options[this.selectedIndex].getAttribute('procedureName');
        var procedurePrice = this.options[this.selectedIndex].getAttribute('procedurePrice');
        $(fieldHTML).append("");
        $("#btn-add").prop("disabled", false);

        $("#procedureName").val(procedureName);
        $("#procedurePrice").val(procedurePrice);

    });
});

$("a#procedureView").click(function (e) {

});

function functionCreate() {
    var _data = {};
    _data["name"] = $("#name").val();
    _data["clientId"] = $("#clientId").data("clientid");
    _data["description"] = $("#description").val();
    _data["dateFrom"] = $("#dateFrom".toString()).val();
    _data["dateTo"] = $("#dateTo".toString()).val();
    //todo тягнути клініку для якої створюється запис. у майбутньому
    _data["clinic"] = "BetskoClinic";
    _data["procedureCriteria"] = [];

    $("[id^='procedureName']").each(function () {
        _data["procedureCriteria"].push({name: $(this).val(), description: '', price: ''});
    });
    $("[id^='procedureDescription']").each(function (index) {
        _data.procedureCriteria[index].description = $(this).val()
    });
    $("[id^='procedurePrice']").each(function (index) {
        _data.procedureCriteria[index].price = $(this).val()
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

            console.log("SUCCESS : ", data);
            var url = new URL(window.location.href);
            var id = url.searchParams.get("id");
            window.location.replace('/admin/client?id=' + id);
        },
        error: function (e) {

            var json = e.responseText;
            $('#result').append(json);
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });
}



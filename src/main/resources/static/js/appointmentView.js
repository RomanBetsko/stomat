$(document).ready(function () {
    var maxField = 20;
    var addButton = $('.add_button');
    var wrapper = $('.field_wrapper');
    var fieldHTML = '<div><input type="text" name="field_name" id="procedure" multiple="multiple" value="" style="margin-top: 5px;"/>' +
        '<a href="javascript:void(0);" class="remove_button"><img src="../remove-icon.png"></a></div>';
    var x = 1;
    $(addButton).click(function () {
        if (x < maxField) {
            x++;
            $(wrapper).append(fieldHTML);
        }
    });
    $(wrapper).on('click', '.remove_button', function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
        x--;
    });
});

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
    document.getElementById("create").onclick = function () {
        functionCreate()
    };
    $("#addclient-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function functionCreate() {
    $("appointment").show();
}



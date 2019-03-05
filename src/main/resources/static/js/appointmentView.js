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

$(function () {
    $('#datetimepicker3').datetimepicker({locale: 'uk'});
    $("#setMinDate").click(function () {
        $('#datetimepicker3').data("DateTimePicker").minDate(moment('05.11.2017', 'DD.MM.YYYY'));
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



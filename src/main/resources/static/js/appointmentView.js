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



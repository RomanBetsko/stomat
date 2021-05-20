$(document).ready(function () {
    var editableItems = $('.procedures-list .editable-item');
    var wrapper = $('.procedures-list');

    editableItems.each(function() {
        $(this).data('content', $(this).text());
    });

    wrapper.on('dblclick', '.editable-item', function() {
        $(this).attr('contenteditable', true).focus();
        $(this).closest('.procedure-item').find('.btn-save').show();
    });

    wrapper.on('blur', '.editable-item', function() {
        var isEdited = false;
        var parent = $(this).closest('.procedure-item');

        $(this).removeAttr('contenteditable');
        parent.find('.editable-item').each(function() {
            if ($(this).text() != $(this).data('content')) {
                isEdited = true;
            }
        });
        if (!isEdited) {
            parent.find('.btn-save').hide();
        }
    });

    wrapper.on('click', '.btn-save', function(e) {
        e.preventDefault();
        var data = {};
        var parent = $(this).closest('.procedure-item').removeClass('procedure-item-new');

        parent.find('.editable-item').each(function () {
            var value = $(this).text();
            switch ($(this).data('name')) {
                case 'title':
                    data.title = value;
                    break;
                case 'price':
                    data.price = value;
                    break;
                case 'description':
                    data.description = value;
                    break;
            }
            $(this).data('content', $(this).text()).removeAttr('contenteditable');
        });

        $(this).hide();
    });

    wrapper.on('click', '.btn-remove', function(e) {
        e.preventDefault();
        if (confirm('Remove?')) {
            $(this).closest('.procedure-item').remove();
        }
    });

    $('.appointment-header .btn-add').on('click', function(e) {
        e.preventDefault();
        var template = $('#procedure-templates').find('.procedure-item').clone();
        $('.procedures-list .row').append(template);
    });


    $('.appointment-header .btn-update').on('click', function(e) {
        e.preventDefault();
        var _data = {};
        _data["name"] = document.getElementById('name').innerText;
        // _data["clientId"] = $("#clientId").data("clientid");
        _data["description"] = document.getElementById('description').innerText;
        _data["id"] = document.getElementById('id').innerText;
        // _data["dateFrom"] = $("#dateFrom".toString()).val();
        // _data["dateTo"] = $("#dateTo".toString()).val();
        // //todo тягнути клініку для якої створюється запис. у майбутньому
        // _data["clinic"] = "BetskoClinic";
        _data["procedureCriteria"] = [];

        var x = $(this).data();
        console.log(x);
        var title = document.getElementsByClassName("card-title editable-item");
        for(var i=0; i<title.length; i++) {
            _data["procedureCriteria"].push({name: title[i].innerText, description: '', price: ''});
        }

        var price = document.getElementsByClassName("card-price editable-item");
        for(var i=0; i<price.length; i++) {
            _data.procedureCriteria[i].price = price[i].innerText;
        }

        var description = document.getElementsByClassName("card-text editable-item");
        for(var i=0; i<description.length; i++) {
            _data.procedureCriteria[i].description = description[i].innerText;
        }
        _data["procedureCriteria"].shift();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/appointment/update",
            data: JSON.stringify(_data),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                console.log("SUCCESS : ", data);
                // var url = new URL(window.location.href);
                // var id = url.searchParams.get("id");
                window.location.replace('/admin/client?id=' + data.msg.toString());
            },
            error: function (e) {

                var json = e.responseText;
                $('#result').append(json);
                console.log("ERROR : ", e);
                $("#btn-add").prop("disabled", false);
            }
        });
    });
});
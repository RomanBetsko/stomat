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

});
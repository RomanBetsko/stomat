$(document).ready(function() {
    $('#calendar').fullCalendar({
        locale : 'uk',
        defaultView: 'agendaWeek',
        //todo запитати Назара чи потрібно це
        minTime: '07:00:00',
        maxTime: '23:00:00',
        html: true,

        //todo подумати що з цим зробити
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        eventRender: function(eventObj, $el) {
            $el.popover({
                title: eventObj.title,
                content: eventObj.description,
                trigger: 'hover',
                html: true,
                placement: 'top',
                container: 'body'
            });
        },
        events: {
            url : '/admin/api/event/all'
        }
    });
});
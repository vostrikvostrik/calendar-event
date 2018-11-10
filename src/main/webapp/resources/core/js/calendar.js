var events;

function findAllEvents() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        type: 'GET', //тип запроса
        url: "events", //url адрес обработчика
        success: function (result) {
            console.log(result);

        }, //возвращаемый результат от сервера
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }
    });

};

function eventsOfDay(date) {
    console.log('events of a day date: ' + date);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        type: 'GET', //тип запроса
        url: "events_on_date/" + formatDate(date), //url адрес обработчика
        success: function (result) {
            var trHTML = '';
            var data = $.parseJSON(result.entity);
            for (var i = 0; i < data.length; i++) {
             trHTML += '<tr><td>' + data[i].id + '</td><td>' + data[i].title + '</td><td>'
                    + data[i].start + '</td></tr>';
            }
            $('#eventsOfDayTable').empty();
            $('#eventsOfDayTable').append(trHTML);
        }, //возвращаемый результат от сервера
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }
    });

};


function formatDate(date) {

    var dd = date.getDate();
    if (dd < 10) dd = '0' + dd;

    var mm = date.getUTCMonth();
    console.log("1. format date " + mm);
    console.log("11. format date " + date.getDate());
    console.log("111. format date " + date.getMonth());
    var yyyy = date.getFullYear();
    if (yyyy < 1000) yyyy = '0' + yyyy;

    if (mm == 0) {
        mm = 12;
        yyyy = yyyy - 1;
    }
    if (mm < 10) mm = '0' + mm;
    console.log("2. format date " + mm);

    return dd + '-' + mm + '-' + yyyy;
}

function displayAddNewEventBlock() {
    var x = document.getElementById("addNewEvent");
    if (x.style.display === "none") {
        x.style.display = "block";
        var but = document.getElementById("displayAddNewEventBlockBut");
        but.style.display = "none";
    } else {
        x.style.display = "none";
    }
}

function addNewEvent() {
    var startDate = document.getElementById("eventStartDate");
    var eventAllDay = document.getElementById("eventAllDay");
    console.log('eventAllDay ' + eventAllDay.value);
    var eventHourMinute = document.getElementById("eventHourMinute");
    var hour = eventHourMinute.value.substr(0, 2);
    var minute = eventHourMinute.value.substr(3, 2);
    console.log('eventHourMinute ' + eventHourMinute.value + '\thour ' + hour +
        '\t minute ' + minute);
    var eventTitle = document.getElementById("eventTitle");
    console.log('eventTitle ' + eventTitle.value);
    var eventClassName = document.getElementById("eventClassName");
    console.log('eventClassName ' + eventClassName.value);
    var allDay = eventAllDay.value == "on" ? true : false;
    console.log('allDay ' + allDay);
    console.log('startDate ' + startDate.value);
    var event = {
        "title": eventTitle.value,
        "start": startDate.value,
        "allDay": allDay,
        "className": eventClassName.value,
        "hour": hour,
        "minute": minute
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "events/add",//url адрес обработчика
        dataType: 'json',
        data: JSON.stringify(event),// Note it is important
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        },
        success: function (e) {
            console.log("DONE");
            var but = document.getElementById("addNewEvent");
            but.style.display = "none";
            but = document.getElementById("displayAddNewEventBlockBut");
            but.style.display = "block";
            var date = startDate.value.split("-");
            eventsOfDay(new Date(date[0], date[1], date[2]));
        }
    });

};

$(document).ready(function () {
    var date = new Date();

    eventsOfDay(date);
    loadDates(date);
});

function loadDates(date) {
    console.log('load dates ' + date);
    var startDate = document.getElementById("eventStartDate");
    startDate.value = date.format('YYYY-MM-DD');
    var eventHourMinute = document.getElementById("eventHourMinute");
    eventHourMinute.value = date.format('hh:mm');
}



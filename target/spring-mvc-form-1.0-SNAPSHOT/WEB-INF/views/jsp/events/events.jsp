<div class="container">
    <div class="row">
        <div class="d-inline-block bg-warning col-sm">
            <h3>Events calendar</h3>
            <div id="datetimepicker12"></div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker12').datetimepicker({
                        inline: true,
                        sideBySide: true
                    }).on('dp.change', function (e) {

                        eventsOfDay(new Date(e.date.format('YYYY'), e.date.format('MM') - 1, e.date.format('DD')));
                        var startDate = document.getElementById("eventStartDate");
                        startDate.value = e.date.format('YYYY-MM-DD');
                        var eventHourMinute = document.getElementById("eventHourMinute");
                        eventHourMinute.value = e.date.format('hh:mm');
                    });
                });

            </script>
        </div>
        <div class="col-sm">
            <div class="float-right">
                <button id="displayAddNewEventBlockBut" class="btn btn-primary" onclick="displayAddNewEventBlock()">Add
                    new
                    event
                </button>
            </div>
            <div id="addNewEvent" style="display: none">
                <form>
                    <div class="form-group row">
                        <label for="eventStartDate" class="col-xs-2 col-form-label">Date and time</label>
                        <div class="col-xs-10">
                            <input class="form-control" type="date" id="eventStartDate">
                        </div>
                    </div>
                    <div class="form-check row">
                        <label class="col-xs-2 form-check-label" for="eventAllDay">all day long</label>
                        <div class="col-xs-10 text-left">
                            <input type="checkbox" class="form-check-input" id="eventAllDay">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="eventHourMinute" class="col-xs-2 col-form-label">Time</label>
                        <div class="col-xs-10">
                            <input class="form-control" type="time" value="00:00:00" id="eventHourMinute">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="eventTitle" class="col-xs-2 col-form-label">Title of event</label>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" id="eventTitle" placeholder="enter title">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="eventClassName" class="col-xs-2 col-form-label">Select event type</label>
                        <div class="col-xs-10">
                            <select class="form-control" id="eventClassName">
                                <option>party</option>
                                <option>routine</option>
                                <option>work</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group pull-right">
                        <div class="col-xs-10">
                            <input type="button" class="btn btn-primary" onclick="addNewEvent();" value="Add new event" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row mx-auto my-2 my-sm-3 my-lg-4 p-3">
        <h3>Events of a day</h3>
    </div>
    <div id="eventsOfDay">
        <table id="eventsOfDayTable" class="table">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Start</th>
            </tr>
        </table>
    </div>
</div>
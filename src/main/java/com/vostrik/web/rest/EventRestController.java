package com.vostrik.web.rest;

import com.vostrik.dao.UserEventDao;
import com.vostrik.model.EventType;
import com.vostrik.model.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping("/rest/api")
@RestController
public class EventRestController {

    @Autowired
    UserEventDao userEventDao;

    @GetMapping("/types")
    public List<String> getEventTypes() {
        return EventType.getEventTypes();
    }

    @GetMapping("/events/{date}")
    public List<UserEvent> getUserEventsOnDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        log.debug("events date " + date.toString());
        return userEventDao.findAll(date);
    }

    @GetMapping("/events")
    public List<UserEvent> getUserEvents() {
        return userEventDao.findAll();
    }
}

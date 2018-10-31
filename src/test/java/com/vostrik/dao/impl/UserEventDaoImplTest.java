package com.vostrik.dao.impl;

import com.googlecode.objectify.Objectify;
import com.vostrik.dao.OfyService;
import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class UserEventDaoImplTest extends AbstractServiceTest {

    @Autowired
    UserEventDao userEventDao;

    UserEvent event;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        initEvents();
    }

    private void initEvents(){
        Objectify ofy = OfyService.ofy();
        UserEvent event = new UserEvent();
        event.setDay(10);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(17);
        event.setMinute(46);
        event.setStart(new Date(2018 - 1900, 12 - 1, 10));
        event.setTitle("first event");
        ofy.save().entity(event).now();

        event = new UserEvent();
        event.setDay(11);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(13);
        event.setMinute(0);
        event.setStart(new Date(2018 - 1900, 12 - 1, 11));
        event.setTitle("second event");
        ofy.save().entity(event).now();

        event = new UserEvent();
        event.setDay(11);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(15);
        event.setMinute(0);
        event.setStart(new Date(2018 - 1900, 12 - 1, 11));
        event.setTitle("third event");
        ofy.save().entity(event).now();


    }

    @Test
    public void findAll() {
        List<UserEvent> result = userEventDao.findAll();
        Assert.notEmpty(result,"result must be not empty");
    }


    @Test
    public void save() {
        event  = new UserEvent();
        event.setHour(15);
        event.setMinute(0);
        event.setStart(new Date(2018 - 1900, 12 - 1, 11));
        event.setTitle("fourth event");
        userEventDao.save(event);
    }

    @Test
    public void findAllBydate() {
        Date date = new Date(2018 - 1900, 12 - 1, 11);
        List<UserEvent> result = userEventDao.findAll(date);
        Assert.notEmpty(result,"results by date must be not empty");
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
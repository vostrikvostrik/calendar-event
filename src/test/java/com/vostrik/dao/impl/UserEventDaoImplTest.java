package com.vostrik.dao.impl;

import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import com.vostrik.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


@Slf4j
public class UserEventDaoImplTest extends AbstractServiceTest {

    @Autowired
    UserEventDao userEventDao;

    UserEvent event;

    @Before
    public void setUp() throws Exception {
        initEvents();
    }

    private void initEvents(){
        UserEvent event = new UserEvent();
        event.setDay(10);
        event.setAllDay(true);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(17);
        event.setMinute(46);

        event.setStart(new Date(2018 - 1900, 12 - 1, 10));
        event.setTitle("first event");
        event.setClassName("routine");
        userEventDao.save(event);

        event = new UserEvent();
        event.setDay(11);
        event.setAllDay(false);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(13);
        event.setMinute(0);
        event.setStart(new Date(2018 - 1900, 12 - 1, 11));
        event.setTitle("second event");
        event.setClassName("party");
        userEventDao.save(event);

        event = new UserEvent();
        event.setDay(11);
        event.setAllDay(false);
        event.setMonth(12);
        event.setYear(2018);
        event.setHour(15);
        event.setMinute(0);
        event.setStart(new Date(2018 - 1900, 12 - 1, 11));
        event.setTitle("third event");
        event.setClassName("routine");
        userEventDao.save(event);

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

}
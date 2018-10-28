package com.vostrik.dao.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.vostrik.dao.OfyService;
import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Getter
@Setter
@Qualifier("userEventDAO")
public class UserEventDaoImpl implements UserEventDao {

    private final Logger logger = LoggerFactory.getLogger(UserEventDaoImpl.class);

    @Override
    public UserEvent findById(Integer id) {
        Objectify ofy = OfyService.ofy();
        UserEvent result = ofy.load().type(UserEvent.class).filter("id", id).first().now();
        return result;
    }

    @Override
    public List<UserEvent> findAll() {
        Objectify ofy = OfyService.ofy();
        List<UserEvent> result = ofy.load().type(UserEvent.class).list();
        logger.debug("result Size: " + result.size());
        logger.debug("result all: " + Arrays.toString(result.toArray()));
        return result;
    }

    @Override
    public List<UserEvent> findAll(Date date) {
        Objectify ofy = OfyService.ofy();
        logger.debug("date to findAll " + date.toString());
        List<UserEvent> result = ofy.load().type(UserEvent.class)
                //.order("hour desc")
                .filter("year =", date.getYear() + 1900)
                .filter("month =", date.getMonth())
                .filter("day =", date.getDay())
                .list();
        logger.debug("result Size: " + result.size());

        return result;
    }

    @Override
    public void save(UserEvent event) {
        Objectify ofy = OfyService.ofy();
        event.setDay(event.getStart().getDay());
        event.setMonth(event.getStart().getMonth());
        event.setYear(event.getStart().getYear() + 1900);
        event.setHour(event.getHour());
        event.setMinute(event.getMinute());
        ofy.save().entity(event).now();
    }

    @Override
    public void update(UserEvent event) {
        Objectify ofy = OfyService.ofy();
        ofy.save().entity(event).now();
    }

    @Override
    public void delete(Integer id) {
        Objectify ofy = OfyService.ofy();
        Key<UserEvent> userDataKey = Key.create(UserEvent.class, id);
        ofy.delete().key(userDataKey);
    }
}

package com.vostrik.dao;

import com.vostrik.model.UserEvent;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UserEventDao {
    UserEvent findById(Integer id);
    List<UserEvent> findAll();
    List<UserEvent> findAll(Date date);
    void save(UserEvent event);
    void update(UserEvent event);
    void delete(Integer id);
}

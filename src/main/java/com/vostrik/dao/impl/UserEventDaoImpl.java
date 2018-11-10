package com.vostrik.dao.impl;

import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import com.vostrik.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Service
@Getter
@Setter
@Qualifier("userEventDAO")
public class UserEventDaoImpl implements UserEventDao {

    private final Logger logger = LoggerFactory.getLogger(UserEventDaoImpl.class);


    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public UserEvent findById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT * FROM UserEvent WHERE id=:id";

        UserEvent result = null;
        try {

            result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserEventMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
            logger.error("findById exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<UserEvent> findAll() {
        String sql = "SELECT * FROM UserEvent";
        List<UserEvent> result = namedParameterJdbcTemplate.query(sql, new UserEventMapper());

        return result;
    }

    @Override
    public List<UserEvent> findAll(Date date) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", date);
        String sql = "SELECT * FROM UserEvent WHERE start=:start";

        List<UserEvent> result = null;
        try {

            result = namedParameterJdbcTemplate.query(sql, params, new UserEventMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
            logger.error(e.getMessage());
        }
        logger.debug("result size " + result.size());
        return result;
    }

    @Override
    public void save(UserEvent event) {

        LocalDate datePart = DateUtil.getDatePart(event.getStart());
        event.setDay(datePart.getDayOfMonth());
        event.setMonth(datePart.getMonthValue());
        event.setYear(datePart.getYear());
        event.setHour(event.getHour());
        event.setMinute(event.getMinute());
        logger.debug("save new event: " + event.toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO UserEvent ( title, className, allDay, year, month, day, hour, minute, start) "
                + " VALUES (:title, :className, :allDay, :year, :month, :day, :hour, :minute, :start)";


        //namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(event), keyHolder, new String[]{"id"});
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(event));
        //event.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(UserEvent event) {

        String sql = "UPDATE UserEvent SET title=:title, className=:className, allDay=:allDay, " + "year=:year, month=:month, day=:day, "
                + "hour=:hour, minute=:minute, start=:start WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(event));
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM UserEvent WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }


    private SqlParameterSource getSqlParameterByModel(UserEvent userEvent) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", userEvent.getId());
        paramSource.addValue("allDay", userEvent.getAllDay());
        paramSource.addValue("className", userEvent.getClassName());
        paramSource.addValue("title", userEvent.getTitle());
        paramSource.addValue("start", userEvent.getStart());
        paramSource.addValue("year", userEvent.getYear());
        paramSource.addValue("month", userEvent.getMonth());
        paramSource.addValue("day", userEvent.getDay());
        paramSource.addValue("hour", userEvent.getHour());
        paramSource.addValue("minute", userEvent.getMinute());

        return paramSource;
    }

    private static final class UserEventMapper implements RowMapper<UserEvent> {

        public UserEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserEvent event = new UserEvent();
            event.setId(rs.getLong("id"));
            event.setStart(rs.getDate("start"));
            event.setTitle(rs.getString("title"));
            event.setAllDay(rs.getBoolean("allDay"));
            event.setClassName(rs.getString("className"));
            event.setDay(rs.getInt("day"));
            event.setHour(rs.getInt("hour"));
            event.setMinute(rs.getInt("minute"));
            event.setMonth(rs.getInt("month"));
            event.setYear(rs.getInt("year"));

            return event;
        }
    }

}

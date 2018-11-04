package com.vostrik.web.ajax;

import com.google.gson.Gson;
import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.Date;

import static javax.ws.rs.core.Response.Status.OK;

@Controller
public class AjaxHelperController {

    private final Logger logger = LoggerFactory.getLogger(AjaxHelperController.class);

    @Autowired
    UserEventDao userEventDao;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public @ResponseBody
    Response getUserEvents() {
        logger.debug("get event list ");
        Gson gson = new Gson();
        return Response.status(OK).entity(gson.toJson(userEventDao.findAll())).build();
    }

    @RequestMapping(value = "/events_on_date/{date}", method = RequestMethod.GET)
    public @ResponseBody
    Response getUserEventsOnDate(@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("date") Date date) {
        logger.debug("get event list by date " + date);
        Gson gson = new Gson();
        return Response.status(OK).entity(gson.toJson(userEventDao.findAll(date))).build();
    }

    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public @ResponseBody
    Response addNewEvent(@RequestBody UserEvent userEvent) {
        logger.debug("add new event: " + userEvent.toString());
        userEventDao.save(userEvent);
        Gson gson = new Gson();
        return Response.status(OK).entity(gson.toJson(userEvent)).build();
    }


}

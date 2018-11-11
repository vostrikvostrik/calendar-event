package com.vostrik.web;

import javax.servlet.http.HttpSession;

import com.vostrik.dao.UserEventDao;
import com.vostrik.model.UserEvent;
import com.vostrik.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller
public class EventsController {

    @Autowired
    UserEventDao userEventDao;

    private final Logger logger = LoggerFactory.getLogger(EventsController.class);



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        return "redirect:/user_events";
    }

    // list page
    @RequestMapping(value = "/user_events", method = RequestMethod.GET)
    public String showAllUsers(HttpSession session, Model model) {
        logger.debug("into user_events");
        return "events/list";
    }
}
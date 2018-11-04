package com.vostrik.web;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
//@EnableOAuth2Sso
@Controller
public class EventsController {

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
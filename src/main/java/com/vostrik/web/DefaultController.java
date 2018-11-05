package com.vostrik.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class DefaultController {
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String index(Model model) {
        log.debug("into default");
        return "index";
    }
}

package com.vostrik.dao.impl;

import com.vostrik.config.SpringWebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("file:src/test/resources/test-web.xml")
//@ContextConfiguration(locations = {"file:src/test/resources/test-spring-web-servlet.xml"})
@ContextConfiguration(classes = SpringWebConfig.class)
public abstract class AbstractServiceTest {

}

package com.vostrik.dao.impl;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import com.vostrik.dao.OfyService;
import com.vostrik.model.UserEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("file:src/test/resources/test-web.xml")
@ContextConfiguration(locations = {"file:src/test/resources/test-spring-web-servlet.xml"})
public abstract class AbstractServiceTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    Closeable session;

    @BeforeClass
    public static void setUpBeforeClass() {
        // Reset the Factory so that all translators work properly.
        OfyService.factory().register(UserEvent.class);
    }
    @Before
    public void setUp() throws Exception {
        session = ObjectifyService.begin();
        helper.setUp();
    }



    @After
    public void tearDown() {
        session.close();
        helper.tearDown();
    }
}

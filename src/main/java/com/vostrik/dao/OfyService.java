package com.vostrik.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.vostrik.model.UserEvent;

/**
 * Custom Objectify Service that this application should use.
 */
//@Service
public class OfyService {

    // This static block ensure the entity registration.
    static {
        factory().register(UserEvent.class);
    }

    // Use this static method for getting the Objectify service factory.
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

    /**
     * Use this static method for getting the Objectify service object in order
     * to make sure the above static block is executed before using Objectify.
     *
     * @return Objectify service object.
     */
    @SuppressWarnings("unused")
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
}

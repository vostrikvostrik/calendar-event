package com.vostrik.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTypeTest {

    @Test
    public void getEventTypes() {
        assertArrayEquals("wrong array of event types", new String[]{"party","work","routine"}, EventType.getEventTypes().toArray());
    }
}
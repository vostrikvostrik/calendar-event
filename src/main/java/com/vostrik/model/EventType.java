package com.vostrik.model;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum EventType {
    PARTY("party"), WORK("work"), ROUTINE("routine");
    private String type;

    EventType(String type) {
        this.type = type;
    }

    public static List<String> getEventTypes(){
        return Stream.of(EventType.values())
                .map(EventType::getType)
                .collect(Collectors.toList());
    }
}

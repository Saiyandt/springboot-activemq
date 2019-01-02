package com.example.statementservice.config;

import com.example.statementservice.event.DomainEvent;
import com.example.statementservice.util.SubclassFinder;

import java.util.Map;
import java.util.stream.Collectors;

public class TypeIdMappingFactory {
    public static Map<String, Class<?>> getTypeIdMapping() {
        return SubclassFinder
                .findAllSubtypes(DomainEvent.class, "com/example/statementservice/event")
                .stream()
                .collect(Collectors.toMap(clazz -> clazz.getSimpleName(), clazz -> clazz));
    }
}

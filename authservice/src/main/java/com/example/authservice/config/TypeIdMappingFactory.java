package com.example.authservice.config;

import com.example.authservice.event.DomainEvent;
import com.example.authservice.util.SubclassFinder;

import java.util.Map;
import java.util.stream.Collectors;

public class TypeIdMappingFactory {
    public static Map<String, Class<?>> getTypeIdMapping() {
        return SubclassFinder
                .findAllSubtypes(DomainEvent.class, "com/example/authservice/event")
                .stream()
                .collect(Collectors.toMap(clazz -> clazz.getSimpleName(), clazz -> clazz));
    }
}

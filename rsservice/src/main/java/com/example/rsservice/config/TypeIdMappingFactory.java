package com.example.rsservice.config;



import com.example.rsservice.event.DomainEvent;
import com.example.rsservice.util.SubclassFinder;

import java.util.Map;
import java.util.stream.Collectors;

public class TypeIdMappingFactory {
    public static Map<String, Class<?>> getTypeIdMapping() {
        return SubclassFinder
                .findAllSubtypes(DomainEvent.class, "com/example/rsservice/event")
                .stream()
                .collect(Collectors.toMap(clazz -> clazz.getSimpleName(), clazz -> clazz));
    }
}

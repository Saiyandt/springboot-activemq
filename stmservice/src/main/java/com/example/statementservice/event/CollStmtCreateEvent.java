package com.example.statementservice.event;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CollStmtCreateEvent implements DomainEvent<CollStmtCreateEvent> {

    @Getter
    @Setter
    private UUID eventId;


    @Setter
    private String content;

    public CollStmtCreateEvent() {}

    public CollStmtCreateEvent(UUID eventId, String type, String content) {
        this.eventId = eventId;
        this.content = content;

    }


    @Override
    public String getContent() {
        return content;
    }


}

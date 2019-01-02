package com.example.statementservice.service;

import com.example.statementservice.domain.StatementDetailDto;
import com.example.statementservice.domain.StatementDto;
import com.example.statementservice.event.CollAchAuthCreateEvent;
import com.example.statementservice.event.CollStmtCreateEvent;
import com.example.statementservice.event.DomainEvent;
import com.example.statementservice.jms.JmsEventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatementService {

    @Autowired
    JmsEventPublisher jmsEventPublisher;

    @Autowired
    ObjectMapper objectMapper;

    public void processingStatement(CollAchAuthCreateEvent collAchAuthCreateEvent) throws Exception {
        // convert content to object
        StatementDto statementDto = objectMapper.readValue(collAchAuthCreateEvent.getContent(), StatementDto.class);

        StatementDetailDto statementDetailDto = new StatementDetailDto();
        statementDetailDto.setPunNumber(statementDto.getPunNumber());
        statementDetailDto.setStmId(statementDto.getStmId());
        statementDetailDto.setTotalAmt("12345.11");

        // create event
        DomainEvent event = new CollStmtCreateEvent();
        ((CollStmtCreateEvent) event).setEventId(UUID.randomUUID());
        ((CollStmtCreateEvent) event).setContent(objectMapper.writeValueAsString(statementDetailDto));

        System.out.println("***** EventID: " + ((CollStmtCreateEvent) event).getEventId());
        System.out.println("***** Content: " + ((CollStmtCreateEvent) event).getContent());

        jmsEventPublisher.sendMessage(event, "CollStmtCreateEvent");
    }
}

package com.example.authservice.controller;

import com.example.authservice.domain.StatementDto;
import com.example.authservice.event.CollAchAuthCreateEvent;
import com.example.authservice.event.DomainEvent;
import com.example.authservice.jms.JmsEventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProducerController {

    @Autowired
    JmsEventPublisher producer;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value="/send")
    public void send() {
        try {
            StatementDto stm = new StatementDto();
            stm.setStmId("123");
            stm.setPunNumber("9999");

            DomainEvent event = new CollAchAuthCreateEvent();
            ((CollAchAuthCreateEvent) event).setEventId(UUID.randomUUID());
            ((CollAchAuthCreateEvent) event).setContent(objectMapper.writeValueAsString(stm));

            System.out.println("***** EventID: " + ((CollAchAuthCreateEvent) event).getEventId());
            System.out.println("***** Content: " + ((CollAchAuthCreateEvent) event).getContent());

            producer.sendMessage(event, "CollAchAuthCreateEvent");

            System.out.println("sent");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

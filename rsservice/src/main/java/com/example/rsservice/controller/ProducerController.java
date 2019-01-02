package com.example.rsservice.controller;

import com.example.rsservice.domain.Event;
import com.example.rsservice.domain.StatementDto;
import com.example.rsservice.jms.Producer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @Autowired
    ObjectMapper objectMapper;


    @RequestMapping(value="/send")
    public void send() {
        try {
            StatementDto stm = new StatementDto();
            stm.setStmId("123");
            stm.setPunNumber("9999");

//            Event newEvent = new Event();
//            newEvent.setEventType("STM");
//            newEvent.setEventMessage(objectMapper.writeValueAsString(stm));
//
//            producer.sendMessage(newEvent);
//            System.out.println("sent");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

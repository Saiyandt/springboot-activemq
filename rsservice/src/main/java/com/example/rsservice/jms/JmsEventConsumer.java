package com.example.rsservice.jms;

import com.example.rsservice.event.CollAchAuthCreateEvent;
import com.example.rsservice.event.CollStmtCreateEvent;
import com.example.rsservice.service.RsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class JmsEventConsumer {


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RsService rsService;


    @JmsListener(destination = "Consumer.B.VirtualTopic.StatementTopic", containerFactory = "jmsFactory")
    public void receiveMessage(@Headers MessageHeaders headers,
                               Message message) throws Exception
    {
        System.out.println("Received from StatementTopic");

        System.out.println("header: " + headers);
        System.out.println("Message: " + message);

        System.out.println(headers.get("messageType"));

        if ("CollStmtCreateEvent".equalsIgnoreCase(headers.get("messageType").toString())) {
            String messagePayload = ((javax.jms.TextMessage) message).getText();
            CollStmtCreateEvent payloadObject = objectMapper.readValue(messagePayload, CollStmtCreateEvent.class);
            System.out.println("ID: " + payloadObject.getEventId());

            rsService.processingStatementDetail(payloadObject);
        } else {
            // check for other type of message
        }
    }

    @JmsListener(destination = "Consumer.B.VirtualTopic.AuthTopic", containerFactory = "jmsFactory")
    public void receiveMessageFromAuth(@Headers MessageHeaders headers,
                               Message message) throws Exception
    {
        System.out.println("Received from AuthTopic");

        System.out.println("header: " + headers);
        System.out.println("Message: " + message);

        System.out.println(headers.get("messageType"));

        if ("CollAchAuthCreateEvent".equalsIgnoreCase(headers.get("messageType").toString())) {
            String messagePayload = ((javax.jms.TextMessage) message).getText();
            CollAchAuthCreateEvent payloadObject = objectMapper.readValue(messagePayload, CollAchAuthCreateEvent.class);

            System.out.println("****** RECEIVED FROM AUTH ***********");
            System.out.println("ID: " + payloadObject.getEventId());


        } else {
            // check for other type of message
        }
    }
}

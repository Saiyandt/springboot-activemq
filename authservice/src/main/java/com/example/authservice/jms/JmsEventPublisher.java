package com.example.authservice.jms;

import com.example.authservice.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;

@Service
public class JmsEventPublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ConnectionFactory connectionFactory;

    public void sendMessage (DomainEvent message, String messageType) {
        System.out.println("Send message to topic: VirtualTopic.AuthTopic");

        jmsTemplate.convertAndSend("VirtualTopic.AuthTopic", message, m -> { m.setStringProperty("messageType", messageType); return m; });

    }


}

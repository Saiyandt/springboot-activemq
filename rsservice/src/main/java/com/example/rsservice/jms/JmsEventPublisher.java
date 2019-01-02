package com.example.rsservice.jms;

import com.example.rsservice.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsEventPublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage (DomainEvent message, String messageType) {
        System.out.println("Send message to topic");
        jmsTemplate.convertAndSend("VirtualTopic.RsTopic", message, m -> { m.setStringProperty("messageType", messageType); return m; });

    }
}

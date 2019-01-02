package com.example.statementservice.jms;

import com.example.statementservice.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsEventPublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage (DomainEvent message, String messageType) {
        System.out.println("Send message to topic: VirtualTopic.StatementTopic");
        jmsTemplate.convertAndSend("VirtualTopic.StatementTopic", message, m -> { m.setStringProperty("messageType", messageType); return m; });

    }
}

package com.example.rsservice.jms;

import com.example.rsservice.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage (Event message) {
        System.out.println("Send message to topic");
        jmsTemplate.convertAndSend("VirtualTopic.Orders", message);
    }
}

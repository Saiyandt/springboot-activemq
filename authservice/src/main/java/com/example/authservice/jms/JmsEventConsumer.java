//package com.example.authservice.jms;
//
//import com.example.authservice.event.CollAchAuthCreateEvent;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//
//@Component
//public class JmsEventConsumer {
//
//    @Autowired
//    ObjectMapper objectMapper;
//
////    @JmsListener(destination = "Consumer.A.VirtualTopic.Orders", containerFactory = "jmsFactory")
////    public void receiveMessage(javax.jms.Message message) throws JMSException {
////        System.out.println("Received");
////
////        String messagePayload = ((javax.jms.TextMessage) message).getText();
////
////        System.out.println(messagePayload);
////    }
//
//    @JmsListener(destination = "Consumer.A.VirtualTopic.AuthTopic", containerFactory = "jmsFactory")
//    public void receiveMessage(@Headers MessageHeaders headers,
//                               Message message) throws Exception
//    {
//        System.out.println("Received");
//
//        System.out.println("header: " + headers);
//        System.out.println("Message: " + message);
//
//        System.out.println(headers.get("messageType"));
//
//        if ("CollAchAuthCreateEvent".equalsIgnoreCase(headers.get("messageType").toString())) {
//            String messagePayload = ((javax.jms.TextMessage) message).getText();
//            CollAchAuthCreateEvent payloadObject = objectMapper.readValue(messagePayload, CollAchAuthCreateEvent.class);
//            System.out.println("ID: " + payloadObject.getEventId());
//        } else {
//            // ignore
//        }
//    }
//}

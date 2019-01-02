package com.example.rsservice.service;

import com.example.rsservice.domain.StatementDetailDto;
import com.example.rsservice.event.CollStmtCreateEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsService {

    @Autowired
    ObjectMapper objectMapper;

    public void processingStatementDetail(CollStmtCreateEvent collStmtCreateEvent) throws Exception {

        StatementDetailDto statementDetailDto = objectMapper.readValue(collStmtCreateEvent.getContent(), StatementDetailDto.class);

        System.out.println("********* AMOUNT: " +  statementDetailDto.getTotalAmt());
    }
}

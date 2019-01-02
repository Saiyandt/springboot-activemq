package com.example.statementservice.event;

public interface DomainEvent<T> {

    String getContent();
}

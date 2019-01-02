package com.example.rsservice.event;

public interface DomainEvent<T> {

    String getContent();
}

package com.example.authservice.event;

public interface DomainEvent<T> {

    String getContent();
}

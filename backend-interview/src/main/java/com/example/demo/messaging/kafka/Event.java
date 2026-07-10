package com.example.demo.messaging.kafka;

import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;

public class Event extends ApplicationEvent {

    public Event() {
        super(Type.COMMIT);
    }

    public Event(Type type) {
        super(type);
    }
}

package com.example.spring.listener;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
public class EntityEvent extends ApplicationEvent {

    private AccessType type;

    public EntityEvent(Object source, AccessType type) {
        super(source);
        this.type = type;
    }

    public AccessType getType() {
        return type;
    }
}

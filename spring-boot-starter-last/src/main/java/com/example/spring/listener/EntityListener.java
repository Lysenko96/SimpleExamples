package com.example.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#p0.type.name == 'READ'")
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println(entityEvent);
    }
}

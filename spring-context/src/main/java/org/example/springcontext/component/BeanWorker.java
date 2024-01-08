package org.example.springcontext.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanWorker {

    @Autowired
    private Entity entity;

//    public BeanWorker(Entity entity) {
//        this.entity = entity;
//    }

    public void beanChecker(){
        System.out.println(this.getClass().getName());
    }
}

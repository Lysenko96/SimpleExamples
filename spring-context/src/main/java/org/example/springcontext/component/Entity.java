package org.example.springcontext.component;

import org.springframework.stereotype.Component;

@Component
public class Entity {

  //@Autowired
    private BeanWorker beanWorker;

    public Entity(BeanWorker beanWorker) {
        this.beanWorker = beanWorker;
    }

    public void show() {
        System.out.println(this);
    }
}

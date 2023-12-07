package org.example.springioc.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {
    //@Autowired // can inject in final but need init in constructor
    //private final Job job;
    private Job job;

    public Human() {
       // job = new Job();
        setJob(job);
    }

    //@Autowired // automatically inject from spring 5 ?
    public Human(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

   //@Autowired // need for inject to setter
    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Human{" +
                "job=" + job +
                '}';
    }
}

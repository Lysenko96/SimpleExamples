package org.example.projectoop.model;

public interface Workable {

    String TO_DO_WORK = "to do work";
    String SPACE = " ";

    default void doJob() {
        System.out.println(this.getClass().getSimpleName() + SPACE + TO_DO_WORK);
    }

    default void doJob(boolean flag) {}
}


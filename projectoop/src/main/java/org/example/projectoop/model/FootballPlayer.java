package org.example.projectoop.model;

public class FootballPlayer implements Workable{

    @Override
    public void doJob(boolean flag) {
        System.out.println(FootballPlayer.class.getSimpleName() + SPACE + TO_DO_WORK);
    }
}

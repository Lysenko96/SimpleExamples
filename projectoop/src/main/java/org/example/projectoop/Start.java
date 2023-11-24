package org.example.projectoop;

import org.example.projectoop.model.Driver;
import org.example.projectoop.model.FootballPlayer;
import org.example.projectoop.model.Teacher;
import org.example.projectoop.model.Workable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {

    //encapsulation
    //polymorphism
    //inheritance
    // override, overload

    private static final String DELIMITER = "-----";

    public static void main(String[] args) {
        Driver driver = new Driver();
        FootballPlayer footballPlayer = new FootballPlayer();
        Teacher teacher = new Teacher();
        List<Workable> workable = new ArrayList<>(Arrays.asList(driver, footballPlayer, teacher));
        workable.forEach(w -> w.doJob(false));
        System.out.println(DELIMITER);
        workable.forEach(Workable::doJob);
    }
}

package org.example.liskov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //bad code
//        PlainAction plainAction = new PlainAction();
//        SpaceshipAction spaceshipAction = new SpaceshipAction();
//        List<Object> objects = Arrays.asList(plainAction, spaceshipAction);
//        for (Object o : objects) {
//            if(o instanceof PlainAction)
//                ((PlainAction) o).makeFly();
//            if(o instanceof SpaceshipAction)
//                ((SpaceshipAction) o).makeFly();
//        }
        // liskov - use generic class or interface for all you subclass
        Fly plain = new PlainAction();
        Fly spaceship = new SpaceshipAction();
        List<Fly> flies = new ArrayList<>(Arrays.asList(plain, spaceship));
        for(Fly action : flies)
            action.makeFly();
    }
}

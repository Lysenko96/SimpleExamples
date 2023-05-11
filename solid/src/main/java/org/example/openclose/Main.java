package org.example.openclose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // open to extend close to change code
    // just add new SoundAction to sounds and run don't change code

    public static void main(String[] args) {
        Sound lion = new LionAction();
        Sound dog = new DogAction();
        List<Sound> sounds = new ArrayList<>(Arrays.asList(lion,dog));
        for(Sound action : sounds)
            action.makeSound();
    }
}
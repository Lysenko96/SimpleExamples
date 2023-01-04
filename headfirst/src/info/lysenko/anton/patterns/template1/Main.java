package info.lysenko.anton.patterns.template1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("duck", 0));
        ducks.add(new Duck("duck2", 2));
        ducks.add(new Duck("duck1", 1));
       // System.out.println(ducks);
        //Collections.sort(ducks);
        Duck[] duckArr = new Duck[]{ducks.get(0),ducks.get(1), ducks.get(2)};
        System.out.println(Arrays.toString(duckArr));
        Arrays.sort(duckArr);
        System.out.println(Arrays.toString(duckArr));
        //System.out.println(ducks);
    }
}

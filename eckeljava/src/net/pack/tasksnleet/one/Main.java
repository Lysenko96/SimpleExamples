package net.pack.tasksnleet.one;

import java.util.Random;

public class Main {

    private int a;
    private char c;
    private static final String MESSAGE = "Hello, World!";
    static int id;

    public static void main(String[] args) {
        System.out.println(System.getProperties());
        Main main = make();
        Main main2 = make();
        System.out.println(main.id);
        System.out.println(main2.id);
        System.out.println(main.id == main2.id);
        System.out.println(main.autoInt(4) instanceof Integer);
        System.out.println(main.getA());
        System.out.println(main.getC());
        System.out.println(MESSAGE);
        System.out.println(new ATypeName());
        System.out.println(new DataOnly());
        System.out.println(main.storage("Hello"));
        System.out.println(StaticTest.i);
        Incrementable.increment();
        System.out.println(StaticTest.i);
        AllTheColorsOfTheRainbow allTheColorsOfTheRainbow = new AllTheColorsOfTheRainbow();
        System.out.println(allTheColorsOfTheRainbow.anIntegerRepresentingColors);
        allTheColorsOfTheRainbow.changeTheHueOfTheColor(234);
        System.out.println(allTheColorsOfTheRainbow.anIntegerRepresentingColors);
    }

    private Integer autoInt(int a) {
        return a;
    }

    private static Main make(){
        ++id;
        return new Main();
    }

    private int storage(String str){
        return str.length() * 2;
    }

    public int getA() {
        return a;
    }

    public char getC() {
        return c;
    }
}

class ATypeName {

}

class DataOnly {

    Random random = new Random();
    int i = random.nextInt();
    double d = random.nextDouble();
    boolean b = random.nextBoolean();

    @Override
    public String toString() {
        return "DataOnly{" +
                "i=" + i +
                ", d=" + d +
                ", b=" + b +
                '}';
    }
}

class Incrementable {

    static void increment(){
        StaticTest.i++;
    }
}

class StaticTest {

    static int i = 47;
}

class AllTheColorsOfTheRainbow {

    int anIntegerRepresentingColors;

    void changeTheHueOfTheColor(int newHue){
        anIntegerRepresentingColors = newHue;
    }
}
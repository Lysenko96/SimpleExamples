package info.lysenko.anton.sort.ex;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    LinkedList<Mountain> mtn = new LinkedList<>();

    public static void main(String[] args) {
        new Main().go();
    }

    public void go(){
        mtn.add(new Mountain("Long-Reindge", 14255));
        mtn.add(new Mountain("Albert", 14433));
        mtn.add(new Mountain("Maroon", 14156));
        mtn.add(new Mountain("Casl", 14265));

        System.out.println(mtn);
        mtn.sort(new NameCompare());
        System.out.println("for name: " + mtn);
        mtn.sort(new HeightCompare());
        System.out.println("for height: " + mtn);

    }

//    class NameCompare implements Comparator<Mountain> {
//
//        @Override
//        public int compare(Mountain mountain, Mountain t1) {
//            return mountain.getName().compareTo(t1.getName());
//        }
//    }
//
//    class HeightCompare implements Comparator<Mountain> {
//
//        @Override
//        public int compare(Mountain mountain, Mountain t1) {
//            return mountain.getHeight() - t1.getHeight();
//        }
//    }
}

class NameCompare implements Comparator<Mountain>, Comparable<Mountain> {

    @Override
    public int compareTo(Mountain mountain) {
        return 0;
    }

    @Override
    public int compare(Mountain mountain, Mountain t1) {
        return mountain.getName().compareTo(t1.getName());
    }
}

class HeightCompare implements Comparator<Mountain> {

    @Override
    public int compare(Mountain mountain, Mountain t1) {
        return mountain.getHeight() - t1.getHeight();
    }
}


class Mountain {

    private String name;
    private int height;

    public Mountain(){

    }

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
package net.pack.leetcodestyle.test;

import java.util.ArrayList;
import java.util.List;

public class Test {


    static void change(int number, List<String> list) {
        number = 100;              // changes only the local copy
        list.add("added");         // changes the object both references point to
        list = new ArrayList<>();  // reassigns only the local copy of the reference
        list.add("lost");
    }

    public static void main(String[] args) {
        int number = 1;
        List<String> list = new ArrayList<>();
        change(number, list);
        System.out.println(number); // 1
        System.out.println(list);   // [added]
    }
}

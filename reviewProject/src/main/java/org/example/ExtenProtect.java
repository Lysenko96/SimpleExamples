package org.example;

import org.example.entity.Protect;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.Semaphore;

public class ExtenProtect extends Protect {

    private enum Text {

    }


    public static void main(String[] args) {
//        ExtenProtect extenProtect = new ExtenProtect();
//        int c = extenProtect.b;
//        List<String> l = Collections.list(Collections.enumeration(List.of()));
//        Properties p;
//        l.add("1");
//        System.out.println(l);
//        MyClass myClass = null;
//        try {
//            Class clazz = Class.forName(MyClass.class.getName());
//            Class[] params = {int.class, String.class};
//            myClass = (MyClass) clazz.getConstructor(params).newInstance(1, "default2");
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
//                 InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        System.out.println(myClass);
//    }

        new ExtenProtect().show();
    }

    void showComparator() {

    }

    void show() {
        List<MyClass> l = Arrays.asList(new MyClass(3, "vasya3"), new MyClass(2, "vasya1"), new MyClass(1, "vasya"));

//        Collections.sort(l);
        System.out.println(l);
    }
}

class MyClass implements //Comparable<MyClass>,
        Comparator<MyClass> {
    private int number;
    private String name = "default";

    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println(number + name);
    }

    @Override
    public int compare(MyClass o1, MyClass o2) {
        System.out.println("compare");
        System.out.println(o1);
        System.out.println(o2);
        if (String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()) == 0
                && o1.getNumber() == o2.getNumber()) return 0;
        else return -1;
    }

//    @Override
//    public int compareTo(MyClass o) {
//        System.out.println("compareTo");
//        System.out.println(o);
//        System.out.println(this);
//        if (String.CASE_INSENSITIVE_ORDER.compare(this.getName(), o.getName()) == 0
//                && this.getNumber() == o.getNumber()) return 0;
//        else return -1;
//    }

    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
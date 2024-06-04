package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        List<?> list = new ArrayList<>(Arrays.asList(new Class0(), new Class1(), new Class2(), new Class3()));
        app.someMethodAddChild((List<? super Class3>) list);
//        scratch.someMethodAddParent((List<? super Class3>) list); // error
        app.someMethod((List<? extends Class3>) list);
        app.someMethodGet((List<? super Class3>) list);
    }

    public void someMethod(List<? extends Class3> list) {
        Class4 class4 = (Class4) list.get(4);
        System.out.println(class4);
        //Class4 class4 = list.getLast(); // error
    }

    public void someMethodAddChild(List<? super Class3> list) {
        list.add(new Class4());
    }

    public void someMethodGet(List<? super Class3> list) {
        Object clazz = list.get(4);
        System.out.println(clazz);
    }

    public void someMethodAddParent(List<? super Class3> list) {
        //  list.add(new Class2()); // error
    }
}

class Class0 {}

class Class1 extends Class0{}

class Class2 extends Class1{}

class Class3 extends Class2{}

class Class4 extends Class3{}

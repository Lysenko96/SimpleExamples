package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main<T> {

    static List<String> l = new ArrayList<String>() {
        {
            l.add("1");
            l.add("23");
        }};


    public static void main(String[] args) {
        Printer<String> p = new Printer<>("second");
        Printer<Integer> p1 = new Printer<>(2);
        Printer<Double> p2 = new Printer<>(3.1);
       // PrinterExtend<B> pe = new PrinterExtend<>(new B());
        PrinterExtend<C> pe2 = new PrinterExtend<>(new C());
        //pe.print();
        pe2.print();
//        p.print();
//        p1.print();
//        p2.print();
        show(p);
        show(new A());
        //show1(new ArrayList<Integer>(Arrays.asList(1,2,3)));
       // show1(new ArrayList<String>(Arrays.asList("one", "two")));
      //  StringBuilder
        System.out.println(l);
    }

    private static <T> void show(T value) {
        System.out.println(value);
    }

    private void show1(List<? extends A> value) {
        System.out.println(value);
    }


}


class Printer<T> {

    T value;

    Printer(){

    }

    Printer(T value){
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }
}

interface C1 {
    void show();
}

interface B1 {

}

class PrinterExtend<T extends A & C1> {

    T value;

    PrinterExtend(){

    }

    PrinterExtend(T value){
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }
}

class A {

}


class B extends A {

}

class C extends  A implements C1 {
    @Override
    public void show() {

    }
}

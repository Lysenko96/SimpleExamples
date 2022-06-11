package net.pack.eckeljava.minitasks.task2;

class Cleanser {
    protected String s = "Cleanser";
    public void append(String a){
        s = new StringBuilder(s).append(a).toString();
    }
    public  void  apply(){
        append(" apply()");
    }

    public static void main(String[] args) {
        Cleanser c = new Cleanser();
        c.apply();
        System.out.println(c);
    }

    @Override
    public String toString() {
        return "Cleanser{" +
                "s='" + s + '\'' +
                '}';
    }
}

public class Detergent extends Cleanser {

    public void scrub(){
        append(" Detergent.scrub()");
        super.apply();
    }

    public static void main(String[] args) {
        Detergent d = new Detergent();
        d.scrub();
        d.apply();
        System.out.println(d);
        System.out.println("check base class");
        Cleanser.main(args);
    }

    @Override
    public String toString() {
        return "Detergent{" + super.toString() + "}";
    }
}

class SubDetergent extends Detergent {

    @Override
    public void scrub(){
        append(" SubDetergent.scrub()");
        super.scrub();
    }
    public void sterilize(){
        s = null;
    }

    public static void main(String[] args) {
        SubDetergent sd = new SubDetergent();
        sd.scrub();
        System.out.println(sd);
        sd.sterilize();
        System.out.println(sd);
        Cleanser.main(args);
        Detergent.main(args);
    }
}

class A {

    public A(int i) {
        System.out.println("A");
    }


    @Override
    public String toString() {
        return "A{}";
    }
}

class B {

    public B(int i) {
        //new A();
        System.out.println("B");
    }

    @Override
    public String toString() {
        return "B{}";
    }

    public static void main(String[] args) {
        System.out.println(new B(23));
    }
}

class C extends A {
     static B b;

     C(int i){
         super(i);
     }

    public static void main(String[] args) {
        System.out.println(new C(1));
        b = new B(2);
        System.out.println(b);
        System.out.println(new C(3));
    }

    @Override
    public String toString() {
        return "C{}";
    }
}
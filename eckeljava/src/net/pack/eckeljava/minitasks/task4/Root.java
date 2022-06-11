package net.pack.eckeljava.minitasks.task4;

public class Root {
    protected Component1 component1 = new Component1(1);
    protected Component2 component2 = new Component2(2);
    protected Component3 component3 = new Component3(3);
}

class Stem extends Root {

    Stem(){
        System.out.println(component1);
        System.out.println(component2);
        System.out.println(component3);
    }

    public static void main(String[] args) {
        System.out.println(new Stem());
    }
}

class Component1 {

    Component1(int i){
        System.out.println("Component1");
    }
}
class Component2 {
    Component2(int i){
        System.out.println("Component2");
    }
}
class Component3 {
    Component3(int i){
        System.out.println("Component3");
    }
}

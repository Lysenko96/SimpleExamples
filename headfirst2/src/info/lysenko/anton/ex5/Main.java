package info.lysenko.anton.ex5;

public class Main {

    public static void main(String[] args) {
        Object a = new A(1);
        System.out.println(a.toString());
    }
}

class A {

    private int a;

    public A(){}
    public A(int a){
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}

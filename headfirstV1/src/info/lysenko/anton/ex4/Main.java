package info.lysenko.anton.ex4;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getA());
        b.setA(1);
        System.out.println(b.getA());
        System.out.println(b.getB());
        b.setB(2);
        System.out.println(b.getB());

    }
}

class A {

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class B extends A {

    private int b;

    @Override
    public int getA() {
        return super.getA();
    }

    @Override
    public void setA(int a) {
        super.setA(a);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

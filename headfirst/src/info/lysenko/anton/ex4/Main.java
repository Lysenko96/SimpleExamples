package info.lysenko.anton.ex4;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getAr());
        b.setAr(1);
        System.out.println(b.getAr());
        System.out.println(b.getB());
        b.setB(2);
        System.out.println(b.getB());
        A a = new A();
        System.out.println(a.getNumber(33));
        System.out.println(a.getNumber(33).getA());
        System.out.println(b.getNumber(32));
      //  System.out.println(b.getNumber(32).getB());
        A a2 = new C();
        a2.getNumber(5);

    }
}

class A {

    private int ar = 20;

    C getNumber(int ar){
        return new C(42 - ar);
    }

    public void generate(){
        System.out.println("generate");
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}

class B extends A {

    private int b;

    @Override
    public D getNumber(int a) {
        return new D(42 - a);
    }

    private int generate(int a){
        return 33 + a;
    }

    @Override
    public int getAr() {
        return super.getAr() + 3;
    }

    @Override
    public void setAr(int a) {
        super.setAr(a);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class C extends B{

    private int a;

    public C() {
    }

    @Override
    public D getNumber(int a) {
        System.out.println(super.getNumber(a).getAr());
        System.out.println(super.getAr());
        System.out.println(super.getNumber(a).getAr() + super.getAr());
        return super.getNumber(a);
    }

    public C(int a){
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class D extends C {

    private int b;
    public D(int b){
        super(b);
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
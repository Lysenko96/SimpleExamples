import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        B b = new B("d");
        A a = new A(1,"a", b);
        try {
            Object clone = a.clone();
            A cloneA = (A) clone;
            //System.out.println(cloneA);
            b.setD("set");
            a.setB(b);
            System.out.println(a);
            System.out.println(cloneA);
            Set<A> set = new HashSet<>();
            set.add(a);
            set.add(cloneA);
            System.out.println(set);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class A implements Cloneable {

    private int a;
    private String s;

    private B b;

    public A() {
    }

    public A(int a, String s, B b) {
        this.a = a;
        this.s = s;
        this.b = b;
    }

    public A(A a){
        this.a = a.getA();
        this.s = a.getS();
        this.b = a.getB();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       // return super.clone(); // change and clone by link B b
        return new A(new A(getA(), getS(), new B(getB()))); // don't change clone by link B b
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        if (a != a1.a) return false;
        if (!Objects.equals(s, a1.s)) return false;
        return Objects.equals(b, a1.b);
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (s != null ? s.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", s='" + s + '\'' +
                ", b=" + b +
                '}';
    }
}

class B {
    private String d;

    public B() {
    }

    public B(B b){
        this.d = b.getD();
    }

    public B(String d) {
        this.d = d;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    //    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public String toString() {
        return "B{" +
                "d='" + d + '\'' +
                '}';
    }
}

package LessonsToInterview.OOPTest;

import LessonsToInterview.AbstractClass.MainAbstractClass;

import java.util.*;
import java.util.Date;
import java.sql.*;
public final class OOPTest implements IShowable{
    String str = "1";
    private static int a = 2;
    OOPTest(){
        //System.out.println(new MainAbstractClass().d);
        NameGames nameGames = new NameGames();
        Map map = new HashMap<>();

        // If we put null in key in map we put key in the last element list
        //

        map.put(null,"test");
        map.put(null,"123");
        MyClass myClass = new MyClass();
       // myClass.show();
        map.put(new MyClass().i,"555");
        map.put(myClass.i,"234");
        System.out.println(map.entrySet());
       // System.out.println(a);
    }

    @Override
     public void showMethod() {

    }

    public static void main(String[] args) {
       new OOPTest();
       // a = 3;
       // System.out.println(a);
        List list = new ArrayList();
        list.add(new N(4,"1"));
        list.add(new N(41,"4"));
        for (Object o:list) {
            //System.out.println( o);
        }
      //  System.out.println(Math.random());
        N n1 = new N();
       // n1.showA();
        //n1.showC();

        // Passing data by value, value not change
        int c = 5;
        n1.addC(c);

        //System.out.println(c);
   /*     Worker worker = new Worker(111);
        System.out.println(worker.getSalary());
        Worker.addSalary(worker);
        System.out.println(worker.getSalary());*/
    /*    B b = new B();
        b.showB1();
        b = new C();
        b.showB1();
        C c1 = new C();
        c1.showB1();*/
        //new C().showB1();
   /*     Gamer gamer1 = new Gamer("cematheslayer",5000);
        Gamer gamer2 = new Gamer("dendi",4999);
        System.out.println("b:"+gamer1.name + gamer1.salary);
        System.out.println("b:"+gamer2.name + gamer2.salary);
        swap(gamer1,gamer2);
        System.out.println("a:"+gamer1.name + gamer1.salary);
        System.out.println("a:"+gamer2.name + gamer2.salary);*/

        //System.out.println(showTest(3));
  /*      D d1 = new D();
         d1.method(new Date());
        System.out.println( d1.getD());*/
  //D d = new D(new Date());
       // System.out.println(d.getString() + d.getD());
    }
    //Gamer gamer1,gamer2;
    public static void swap(Gamer gamer1, Gamer gamer2){
        Gamer temp = gamer1;
        gamer1 = gamer2;
        gamer2 = temp;
        System.out.println(gamer1.name + gamer1.salary);
        System.out.println(gamer2.name + gamer2.salary);
    }


    public static int showTest(int a){
        return a;
    }

}

 class Gamer{
    String name;
    int salary;
    static  int b;
    Gamer(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    Gamer(){

    }
    {
          b = 3;
     }
}
class D{
    private Date d = null;
    private String string = null;
    //GregorianCalendar calendar = new GregorianCalendar();
   public D(){

    }
    void method(Date d){
        new GregorianCalendar().setTime(d);
        this.d = d;
    }
    private Date getD() {
        return d;
    }

    private void setD(Date d) {
        this.d = d;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    private D(String date, Date d){
        this.string = date;
        this.d = d;
    }
    private D(Date d){
        this("Date: ",d);
        //this.d = d;
    }

    @Override
    public String toString() {
        return "D{" +
                "d=" + d +
                '}';
    }
}
 class B {
    protected void showB1(){
        System.out.println("DD");
    }
}
class C extends B{
    public void showB1() {
        System.out.println("B1");
    }
}
class  Worker{
    private int salary;
    Worker(int salary){
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void addSalary(Worker worker){
        worker.salary = worker.salary + worker.salary;
    }
}

class N{
    N(){

    }
    public static void addC(int c){
        c = c + 2;
        //System.out.println(c);
    }
    int a1;
    String b1;

    N(int a, String b){
         a1 = a;
         b1 = b;
    }
    private int c = 3;

    public void showA(){

        System.out.println(c);
    }
    public void showC(){
        System.out.println(getC());
    }
    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    @Override
    public String toString() {
        return "N{" +
                "a1=" + a1 +
                ", b1='" + b1 + '\'' +
                '}';
    }
}


class MyClass {
    int i = 3;
    A a = new A();
    void show(){
        System.out.println(a.str = "2");
       // a.showA();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return i == myClass.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
final class A extends N{
    @Override
    public String toString() {
        return super.toString();
    }

    String str = " 123";
}
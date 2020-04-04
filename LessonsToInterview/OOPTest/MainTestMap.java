package LessonsToInterview.OOPTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import  org.omg.CORBA.*;

public class MainTestMap {
    MyClassForMap myClassForMap = new MyClassForMap();

    MainTestMap(){
        myClassForMap.setI(3);
        //System.out.println(myClassForMap.getI());

        //If we put null in key in map we put our object in last element in list

        IntHolder a = new IntHolder(100);

        Integer b = 1000;
        //if(a == b)
           // System.out.println("a == b");
        Integer d = 200;
        Integer c = 200;
        if(c == d)
            System.out.println("c == d");
        Integer d1 = 100;
        Integer c1 = 100;
        if(d1.equals(c1))
            System.out.println("d1 equals c1");
        int a1 = 200;
        int b1 = 200;
        if(a1 == b1)
            System.out.println("a1==b1");
        Map map = new HashMap<String,MyClassForMap>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList1.add("5");
        arrayList1.add("6");
        arrayList1.add("7");
        arrayList = arrayList1;
        for (String s:
             arrayList) {
            System.out.println(s);
        }
       // Object o = new Object();
      //  o = null;
        //map.put(o,myClassForMap);
        myClassForMap.setI(33);
        myClassForMap.setD(11);
      //  map.put(o,myClassForMap.toString());
     //   Object o1 = new Object();
      //  o1 = null;
        //myClassForMap.setD(12);
      //  map.put(o1,myClassForMap.toString());
       // System.out.println(map.get(o1));
      //  System.out.println(map.entrySet());
        System.out.println(a.value);
        new ClassAdd().showAdd(a);
        System.out.println(a.value);
        int cc = a.value;
        System.out.println(cc);
    }
    public static void main(String[] args) {
        new MainTestMap();
    }
}
class MyClassForMap{
    // If we don't want use our class in other class we can set private modifier in constructor
  /*  private MyClassForMap(){

    }*/
   MyClassForMap(){

  }
    private int i = 0;
   private int d = 0;

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getI(){ return i;}
    public void setI(int i){ this.i = i;}

    @Override
    public String toString() {
        return "MyClassForMap{" +
                "i=" + i +
                ", d=" + d +
                '}';
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyClassForMap)) return false;
        MyClassForMap that = (MyClassForMap) o;
        return i == that.i &&
                d == that.d;
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(i, d);
    }
}

class ClassAdd{
    void showAdd(IntHolder x){
        x.value *= 3;
        System.out.println(x.value);
    }

}
package LessonsToInterview.StaticTest;

public class StaticMain {
    public int d  = 4;
   private  int i = 2;
   private  int j = 2;
    protected int abc = 11;
    public   int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public StaticMain() {
      //  show();
       // setI(5);
     //show();
     Person person = new Person();
     Person person1 = new Person();
     person = null;
     person1 = null;
     try {

         System.out.println(person.name);
         System.out.println(person1.name);
     } catch (NullPointerException e){

     }
    }
    public static void main(String[] args) {
        new StaticMain();

    }
      void show(){
        System.out.println(getI());
    }
    void show1(){
        System.out.println(getI());
    }
}



 class Person{
    String name = "Tom";
}

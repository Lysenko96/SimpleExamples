package PolymorphTest;


import LessonsToInterview.StaticTest.StaticMain;

public class MainTestConstructor extends TestConstructor {
    private int i = 5;

    MainTestConstructor[] mainTestConstructors = new MainTestConstructor[3];

    @Override
    public int getI() {
        return i;
    }

    @Override
    public void setI(int i) {
        this.i = i;
    }

    MainTestConstructor(){

        // throw java.lang.ArrayStoreException

        SubTestConstructor[] subTestConstructors = new SubTestConstructor[3];
        SubTestConstructor subTestConstructor = new SubTestConstructor();
        TestConstructor[] testConstructor = subTestConstructors;
        TestConstructor testConstructor1 = new TestConstructor();
        try {
        testConstructor[0] = testConstructor1;
            testConstructor1.show();
        } catch (ArrayStoreException e){
            System.out.println("ArrayStoreException");
            //subTestConstructor.show1();
            testConstructor1.show();
        }
        finally {
            System.out.println("We try call method SuperClass's in SuperClass through memory SubClass");
        }

    }

    public static void main(String[] args) {
        new MainTestConstructor();
    }
}

class SubTestConstructor extends TestConstructor{
public void show1(){
    System.out.println("bla");
}
}

class TestConstructor extends StaticMain  {
    private int i = 3;
    private int abc;
    void showABC(){
       StaticMain staticMain = new StaticMain();
       //staticMain.abc = 33;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

     TestConstructor(){
         this.i = i;

    }
    TestConstructor(int i){
         i = this.i;
        System.out.println(i);
    }
    public void show(){
        System.out.println("test");
    }
}
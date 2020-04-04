package LessonsToInterview.OOPTest;

import java.util.concurrent.Callable;

public class MainTestCallableAndRunnable {

    // interface Runnable not have return value but interface Callable have him
    static {
        MySubThreadClass mySubThreadClass = new MyThreadDaemon();
        mySubThreadClass.setDaemon(true);
        mySubThreadClass.start();
        Thread.yield();
    }
    MainTestCallableAndRunnable(){
        //MySubThreadClass mySubThreadClass = new MySubThreadClass();
new SubCZ();
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        MySubThreadClass subThreadClass = new MySubThreadClass();
        subThreadClass.start();
        MyThreadWithReturn myThreadWithReturn = new MyThreadWithReturn();
        myThreadWithReturn.setString("Start MyThreadWithReturn");


        try {
            myThreadWithReturn.call();
            System.out.println(myThreadWithReturn.getString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new MainTestCallableAndRunnable();
    }
}
class MyThreadDaemon extends MySubThreadClass{
    @Override
    public void run() {
        System.out.println("Start ThreadDaemon");
    }
}
class MySubThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("Start MySubThreadClass from Thread");;
    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Start MyThread from Runnable");
    }
}

class MyThreadWithReturn implements Callable{
    private String string;
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String call() throws Exception {
        return string;
    }
}
  class AB{
    private int i;

    protected int getI() {
        return i;
    }

     void setI(int i) {
        this.i = i;
    }
}
final class CD extends AB{
    private int i;

    @Override
    protected int getI() {
        return i + 11  ;
    }

    @Override
     public void setI(int i) {
        super.setI(i);
    }
}
class CZ {
CZ(){
    CZ cz =null;
}
}
class SubCZ extends CZ{
     SubCZ(){
         SubCZ subCZ = null;
         if(subCZ instanceof CZ) {
             subCZ = (SubCZ) new CZ();
         }
     }



}
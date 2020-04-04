package LessonsToInterview.AbstractClass;

import LessonsToInterview.StaticTest.StaticMain;
import LessonsToInterview.StaticTest.StaticMain;

public class MainAbstractClass {
    public int d = 5;
   public MainAbstractClass(){
      int c = new StaticMain().d;
       this.d = c;
        String string = "ACD";
       // System.out.println(string.compareTo("AS"));

        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void showMethod() {
                System.out.println("instance");
            }
        }; // - we don't create instance
        ITestable iTestable = new ITestable() {
            @Override
            public void showText() {
                System.out.println("text2");
            }

            @Override
            public void showSomething() {
                System.out.println("instanceInterface");

            }
        };
   /*     iTestable.showText();
        iTestable.showSomething();
        abstractClass.showMethod();
        System.out.println(abstractClass.returnString("instanceStr"));
        ChildAbstractClass childAbstractClass = new ChildAbstractClass();
        System.out.println(childAbstractClass.returnString("childAbstractClass"));
        childAbstractClass.showMethod();
        childAbstractClass.methodShow(new ChildAbstractClass());*/
    }

    public static void main(String[] args) {
        new MainAbstractClass();
    }
}

package LessonsToInterview.AbstractClass;

public interface ITestable {
    String str = "4124";
     void showSomething();
     default void showText(){
        System.out.println("text");
    }
}

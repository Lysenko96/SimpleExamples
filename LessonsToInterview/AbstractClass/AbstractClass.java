package LessonsToInterview.AbstractClass;

public abstract class AbstractClass {
    public static String str1 = "1";
    abstract void showMethod();
    String returnString(String str){
        str1 = "3";
        System.out.println(str1);
        return str;
    }

}

package LessonsToInterview.AbstractClass;

public class ChildAbstractClass extends AbstractClass {


    @Override
    void showMethod() {
        super.returnString(str1);
        System.out.println("showMethod()");
        System.out.println(str1);
    }
    public static String str1 = "2";
    @Override
    String returnString(String str) {
        System.out.println(str1);
        return str;
    }

    public <T> void methodShow(T type){
        System.out.println(type.getClass());
        System.out.println(type);
    }
}

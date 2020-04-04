package LessonsToInterview.InnerClassTest;

public class MainInnerClass {
    private static String name = InnerClass.getNameInner();
    private static StringBuilder stringBuilder = new StringBuilder();
    private MainInnerClass(){
       // setName(name.append("Main class"));
      // name = InnerClass.getNameInner();
       // System.out.println(getName());
        new InnerClass();
        new TestClass();
       // System.out.println(name);
       // System.out.println(stringBuilder);
        System.out.println("name: "+ getName());
    }
    private static String getName() {
        return MainInnerClass.name;
    }

    private static void setName(String name) {
        MainInnerClass.name = InnerClass.getNameInner();
    }

    public static void main(String[] args) {
        new MainInnerClass();
    }
    public static class InnerClass{
        private static String nameInner = null;
        InnerClass(){
            setName("Inner Class");
            //System.out.println("nameInner: " + getNameInner());
        }

        public static String getNameInner() {
            return nameInner;
        }

        public static void setNameInner(String nameInner) {
            InnerClass.nameInner = nameInner;
        }
    }
}
 class TestClass{
    TestClass(){
        //System.out.println(MainInnerClass.getName());
        MainInnerClass.InnerClass.setNameInner("Test");
        System.out.println(MainInnerClass.InnerClass.getNameInner());
        //MainInnerClass.setName("");
        //System.out.println(MainInnerClass.getName());

    }
}

package info.lysenko.anton;

public class Main {
    public static void main(String[] args) {

        //sdfsdfsf
        // \u000a System.out.println("sdfs");
        System.out.println(new Main().new A<String>("str"));
    }

    private class A<T> {

        T type;

        A(){}

        A(T type){
            this.type = type;
        }

        public <T extends A & B> void show(T value){
            System.out.println(value);
        }

        @Override
        public String toString() {
            return "A{" +
                    "type=" + type +
                    '}';
        }
    }

    interface B {

    }
}



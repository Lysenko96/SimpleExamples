package info.lysenko.anton.ex6;

public class Main {

    static final int x = 12;

    public static void main(String[] args) {
        new Main().show(x);
    }

    void show(final  int x){
        System.out.println(x);
    }
    static class StaticClass {

        private StaticClass(){}

        void show(){
            System.out.println("StaticClass");
        }
    }
}

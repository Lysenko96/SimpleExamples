package info.lysenko.anton.ex8;

public class Main extends StaticSuper {

    static int rand;
    Boolean b;
    boolean b1;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static unit " + rand);
    }

     Main(){
        System.out.println("constructor");
         System.out.println(b);
         System.out.println(b1);
    }

    public static void main(String[] args) {
        System.out.println("inner main");
        Main m = new Main();
    }

}

class StaticSuper {
    static {
        System.out.println("super static unit");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }
}

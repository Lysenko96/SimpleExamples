package info.lysenko.anton.ex7;

public class Main {

    Integer i;
    int j;

    public static void main(String[] args) {
        new info.lysenko.anton.ex7.Main().go();
    }

    public void go(){
        j = i;
        System.out.println(i);
        System.out.println(j);
    }
}

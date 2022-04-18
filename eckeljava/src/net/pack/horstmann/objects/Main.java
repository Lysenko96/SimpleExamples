package net.pack.horstmann.objects;

public class Main {

    private String s;

    public Main(){
        this("Main(String s)");
    }

    public Main(String s){
        this.s = s;
        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.println(new Main());
    }
}



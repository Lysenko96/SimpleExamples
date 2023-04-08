package tasks.lambda.anonymclass;

public class Main2 {

    public final int val = 4;

    public void doIt(){
        int val = 6;
        Runnable r = new Runnable() {
            public final int val = 5;
            @Override
            public void run() {
                int val = 10;
                System.out.println(this.val);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.doIt();
    }
}

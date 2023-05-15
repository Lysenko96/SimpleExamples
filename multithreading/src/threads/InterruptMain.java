package threads;

public class InterruptMain {

    public static void main(String[] args) {
        Runnable r = () -> {
            for(int i = 0; i < 100_000_000; i++)
            System.out.println(i);
        };
        try {
            Thread t = new Thread(r);
            t.start();
            Thread.sleep(1000);
            t.interrupt();
            if(t.isInterrupted()){
              System.exit(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

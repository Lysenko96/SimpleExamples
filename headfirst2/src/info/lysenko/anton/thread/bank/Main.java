package info.lysenko.anton.thread.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        ClientJob job = new ClientJob();
        Thread one = new Thread(job);
        Thread two = new Thread(job);
        one.start();
        two.start();
//        try {
//            one.join();
//            two.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}

class BankAccount {

    private int balance = 100; // AtomicInteger

    public int getBalance(){ return balance; }

    public void calcBalance(int amount) { balance =- amount; }
}

class ClientJob implements Runnable {

    private BankAccount account = new BankAccount();

    @Override
    public void run() {
        for(int i = 0; i < 2; i++){
            synchronized (this) {
                makeCalcBalance(10);

            if(account.getBalance() < 0)
                System.out.println("up limit");
            }
        }
    }

    private void makeCalcBalance(int amount){
        synchronized (this) {
            if (account.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() + " want get money");
                try {
                    System.out.println(Thread.currentThread().getName() + " go to sleep");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " awaking");
                //synchronized (this) {
                account.calcBalance(amount);
                //}
                System.out.println(Thread.currentThread().getName() + " close transaction");
            } else {
                System.out.println("sorry " + Thread.currentThread().getName() + " no money");
            }
        }
    }
}

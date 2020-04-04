package LessonsToInterview.MultithreadingTest.BankTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
     public Bank(int n, double initialBalance){
         accounts = new double[n];
         for (int i = 0; i < accounts.length; i++)
             accounts[i] = initialBalance;
     }
     volatile boolean doneVolatile = false;
     boolean done;
     public void transfer(int from, int to, double amount){
         bankLock.lock();
         try {
            // System.out.println(doneVolatile);
             if (accounts[from] < amount) return;
             System.out.println(Thread.currentThread());
             accounts[from] -= amount;
             System.out.printf(" %10.2f from %d", amount, from, to);
             accounts[to] += amount;
             System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
         } finally {
             bankLock.unlock();
         }
     }
     public double getTotalBalance(){
         bankLock.lock();
         try {
             double sum = 0;
             for (double a : accounts)
                 sum += a;
             return sum;
         } finally {
             bankLock.unlock();
         }
     }
     public  int size(){ return accounts.length;}
}

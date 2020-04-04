package LessonsToInterview.MultithreadingTest.Bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private double totalMoney = 0;

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    Map<StringBuffer, Double> accounts = new HashMap<>();
    Users users = new Users();
    Bank() {
        for (int i = 0; i < 10 ; i++) {
            //users.setMoneyUser(100);
            accounts.put(users.generateNameUser(), users.generateMoneyUser());
            System.out.println("Name: " + users.getGenerateName() + " Money: " + users.getMoneyUser());
           // this.transferBank(users,users,100.0);
           // System.out.println("Name: " + users.getGenerateName() + " Money: " + users.getMoneyUser());
            setTotalMoney(totalMoney += users.getMoneyUser());
        }
       // System.out.println(accounts.entrySet());
        System.out.printf("totalMoney: %.2f", getTotalMoney());
       // System.out.println("totalMoney: " + getTotalMoney());
    }
/*
    public Map<StringBuffer, Double> transferBank(Users from, Users to, double amount){
        from.setMoneyUser(from.getMoneyUser() - amount);
        to.setMoneyUser(to.getMoneyUser() + amount);
        return accounts;
    }*/


    public static void main(String[] args) {
        new Bank();
    }
}

package LessonsToInterview.MultithreadingTest.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Users {
    private double moneyUser = 0;
    private List<Character> nameWords = new ArrayList<>();
   private StringBuffer generateName = null;
   Users(){
   }
    public StringBuffer getGenerateName() {
        return generateName;
    }

    public void setGenerateName(StringBuffer generateName) {
        this.generateName = generateName;
    }

    public double getMoneyUser() {
        return moneyUser;
    }

    public void setMoneyUser(double moneyUser) {
        this.moneyUser = moneyUser;
    }

    public StringBuffer generateNameUser(){
        nameWords.add('a');
        nameWords.add('b');
        nameWords.add('c');
        nameWords.add('d');
        nameWords.add('e');
        nameWords.add('f');
        nameWords.add('g');
        nameWords.add('l');
        nameWords.add('o');
        nameWords.add('i');
        nameWords.add('u');
        nameWords.add('y');
        nameWords.add('k');
        nameWords.add('n');
        nameWords.add('m');
        nameWords.add('p');
        nameWords.add('t');
        nameWords.add('s');
        nameWords.add('r');
        nameWords.add('w');
        nameWords.add('x');
        nameWords.add('z');
        Collections.shuffle(nameWords);
        this.generateName = new StringBuffer("" + nameWords.get(0) + nameWords.get(1) + nameWords.get(2) +
                nameWords.get(3) + nameWords.get(4) + nameWords.get(5));
        //System.out.println(this.generateName);
        return this.generateName;
    }
    public Double generateMoneyUser(){
        Random random = new Random();
        this.moneyUser = random.nextDouble()* 100;
        BigDecimal bd = new BigDecimal(this.moneyUser);
        bd = bd.setScale(2,RoundingMode.HALF_UP);

        this.moneyUser = Double.parseDouble(String.valueOf(bd));
        //System.out.printf("%.2f", this.moneyUser);
      // return this.moneyUser;
        return this.moneyUser;
    }

    public static void main(String[] args) {
       Users user = new Users();
        System.out.println(user.generateNameUser());
        System.out.println(user.generateMoneyUser());
    }
}

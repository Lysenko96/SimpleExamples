package info.lysenko.anton.minitasks.ex4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        int n3;
        System.out.print(n0 + " " + n1 + " " + n2 + " ");
        for(int i = 0; i < 10; i++){
            n3 = n1 + n0 + n2;
            System.out.print(n3 + " ");
            n0 = n1;
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter: ");
        while (in.hasNext()){
            String text = in.nextLine();
            if(text.equals("quit")) break;
            List<String> list = new ArrayList<>(Arrays.asList(text.split("")));
            Collections.reverse(list);
            for(String l : list)
            System.out.print(l);
            System.out.println();
        }
    }
}
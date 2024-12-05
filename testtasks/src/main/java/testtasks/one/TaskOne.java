package testtasks.one;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class TaskOne {

    public static void main(String[] args) {
        TaskOne taskOne = new TaskOne();
        Scanner input = new Scanner(System.in);
        Set<String> results = new LinkedHashSet<>();
        while (true) {
            // input data
            System.out.print("Please enter a number N: ");
            int n = input.nextInt();
            if (n == 0) {
                break;
            }
            System.out.print("Please enter a parentheses: ");
            String line = input.next();
            ArrayDeque<String> queue = new ArrayDeque<>();
            boolean start = false;
            try {
                // check valid parentheses
                taskOne.checkValidParentheses(queue, line, start, results, n);
                results.stream().filter(r -> r.length() / 2 == n).forEach(System.out::println);
            } catch (NoSuchElementException e) {
                // if not correct parentheses output result
                results.stream().filter(r -> r.length() / 2 == n).forEach(System.out::println);
            }
        }
    }

    private void checkValidParentheses(ArrayDeque<String> queue, String line, boolean start, Set<String> results, int n) {
        String[] parentheses = line.split("");
        for (String symbol : parentheses) {
            if (symbol.equals("(")) {
                start = true;
                queue.addFirst(symbol);
            } else if (symbol.equals(")")) {
                queue.removeLast();
            }
        }
        if (queue.isEmpty() && start && parentheses.length / 2 == n) {
            results.add(line);
        }
    }
}

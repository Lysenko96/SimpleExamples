package com.example.spring;

public class Main {

    private static int i;

    public static void main(String[] args) {
        new Main().solve(5, 'a', 'c', 'b');
        System.out.println(i);
    }

    void solve(int n, char from, char to, char via) {
        if (n == 0) return;
        solve(n - 1, from, via, to);
        move(from, to);
        solve(n - 1, via, to, from);
    }

    void move(char from, char to) {
        System.out.println("from: " + from + " to: " + to);
        i++;
    }
}

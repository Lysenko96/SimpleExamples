package countsum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countTriples(10));
    }

    public int countTriples(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        return find_all_triplets(arr, n);
    }

    static int find_all_triplets(int[] arr, int n) {
        Set<A> l = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.pow(arr[i], 2) + Math.pow(arr[j], 2) == Math.pow(arr[k], 2)) {
                        l.add(new A(arr[i], arr[j], arr[k]));
                        l.add(new A(arr[j], arr[i], arr[k]));
                    }
                }
            }
        }
        return l.size();
    }
}

class A {

    private int a;
    private int b;
    private int c;

    public A(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a1 = (A) o;
        return a == a1.a && b == a1.b && c == a1.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

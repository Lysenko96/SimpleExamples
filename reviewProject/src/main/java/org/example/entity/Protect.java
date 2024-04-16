package org.example.entity;

public class Protect {

   static class  Inner {
//       int g = new Protect().a;
    }

    private int a;
    protected int b;

//    int d = new Inner().g;

    public static void main(String[] args) {
        String s = "123";
        String ss = new String("123").intern();
        System.out.println(ss == s);
        System.out.println(s.equals(ss));
    }


}


package org.example.pattern.delegate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DelegateList implements Cloneable, Serializable {

    List<String> list = new ArrayList<>();

    void add(String s) {
        list.add(s);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}


class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        DelegateList d = new DelegateList();
        d.add("1");
        System.out.println(d.list);
        d.clone();
    }

}
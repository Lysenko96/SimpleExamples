package com.example.javabasic.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilClass<T> {

    private List<? extends T> list;

    public List<? extends T> getList() {
        return list;
    }

    public void setList(List< ? extends  T> list) {
        this.list = list;
    }

    List<T> getAll(List<T> list) {
        return list;
    }

    static <T> T getFirst(List<T> list) {
        return list.get(0);
    }

    private void printAll(List<?> list) {
        list.forEach(System.out::println);
    }

    void method(List<String>... lists){
        Object[] arr = lists;
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        arr[0] = integers;
        Arrays.stream(lists).forEach(System.out::println);
       // String val = lists[0].get(0); // error cast generic and array
    }

    public static void main(String[] args) {
        List<?> list1 = new ArrayList<>();
        list1.add(null);// in Type<?> set only null use for read
        UtilClass<String> utilClass1 = new UtilClass<>();
        List<String> strings = new ArrayList<>();
        strings.add("1");
        utilClass1.getAll(strings); // in Type<T> set one type T
        UtilClass<BaseEntity> utilClass2 = new UtilClass<>(); // ? extends BaseEntity
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity());
        utilClass2.setList(entities); // need ? extends BaseEntity that set List<Entity>
        Integer[] b = new Integer[]{};
        Object[] a = b; // Array can cast
        List<Integer> list2 = new ArrayList<>();
        //List<Object> objects = list2; //error Generic cast
        new UtilClass<>().method(Arrays.asList());
    }

}

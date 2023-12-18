package com.example.javabasic.reflection;

import com.example.javabasic.generic.UtilClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Reflection {

    public static void main(String[] args) {
        Method[] methods = UtilClass.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        Method method = methods[2];
        Arrays.stream(method.getParameters()).forEach(System.out::println);
//        UtilClass utilClass = new UtilClass();
        UtilClass utilClass = null;
        try {
           // Class<UtilClass> clazz = UtilClass.class; // example first get class
            Class<?> clazz = Class.forName("com.example.javabasic.generic.UtilClass"); // example second get class
            Arrays.stream(clazz.getClasses()).forEach(System.out::println);
            Constructor<?> constructor = clazz.getConstructor();
            utilClass = (UtilClass) constructor.newInstance();
            utilClass.setList(List.of(1,2));
            System.out.println(utilClass.getList());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            method.setAccessible(true);
            Object result = method.invoke(utilClass, Arrays.asList(1,2,3));
            System.out.println(result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MyCommand myCommand = new MyCommand();
        for (Method method : MyCommand.class.getDeclaredMethods()) {
            method.setAccessible(true);
            method.invoke(myCommand);
            if (method.isAnnotationPresent(Command.class)) {
                Command command = method.getAnnotation(Command.class);
                StringBuilder sb = new StringBuilder();
                sb.append(command.value()).append(System.lineSeparator())
                        .append(command.priority()).append(System.lineSeparator())
                        .append(command.description()).append(System.lineSeparator())
                        .append(Arrays.toString(command.aliases()));
                System.out.println(sb);
            }
        }
        MyCommand command = new MyCommand();
//        command.command();
    }
}



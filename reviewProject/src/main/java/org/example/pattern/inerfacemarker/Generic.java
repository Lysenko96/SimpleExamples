package org.example.pattern.inerfacemarker;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Generic {

    void marker() throws Exception;

    default boolean isMarked(Class<?> clazz) throws Exception {
        if(Arrays.stream(clazz.getInterfaces()).collect(Collectors.toSet()).contains(Markable.class)) return true;
        else throw new Exception("not implements Markable");
    }
}

package com.example.springiocdemo;

import com.example.springiocdemo.config.Bean;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CustomContext {

    private Map<String, Object> beans = new HashMap<>();

    public CustomContext() {
        init();
    }

    private void init() {
        String currentPackage = getClass().getPackageName();
        Reflections reflections = new Reflections(currentPackage);
        reflections.getTypesAnnotatedWith(Bean.class)
                .forEach(this::registerBean);
    }

    private void registerBean(Class<?> clazz) {
        Bean bean = clazz.getAnnotation(Bean.class);
        String beanId = bean.value();
        try {
            Object beanInstance = clazz.getDeclaredConstructor().newInstance();
            beans.put(beanId, beanInstance);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        System.out.println(beans.values());
        return beans.values()
                .stream()
                .filter(clazz::isInstance)
                .findAny()
                .map(clazz::cast)
                .orElseThrow();
    }
}

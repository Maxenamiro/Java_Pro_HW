package com.gmail.maxenamiro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = TextContainer.class;
        Method[] methods = cls.getDeclaredMethods();

        if (cls.isAnnotationPresent(SaveTo.class)) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(Saver.class)) {
                    SaveTo anParam = cls.getAnnotation(SaveTo.class);
                    m.invoke(new TextContainer(), anParam.path());
                    System.out.println("Данные в файл сохранены");
                }
            }
        }
    }
}
package com.gmail.maxenamiro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        final Class<?> cls = TestClass.class;
        Method[] methods = cls.getDeclaredMethods ();
        for (Method m:methods){
            if (m.isAnnotationPresent(Test.class)){
                Test an = m.getAnnotation(Test.class);
                m.invoke(new TestClass(), an.a(), an.b());
            }
        }
    }
}

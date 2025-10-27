package com.improvemyskills.javaavance.discovery;

import java.lang.reflect.*;

public class DynamicInvocationExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Object str = constructor.newInstance("Hello Reflection");

        Method method = clazz.getMethod("toUpperCase");
        System.out.println(method.invoke(str)); // HELLO REFLECTION
    }
}
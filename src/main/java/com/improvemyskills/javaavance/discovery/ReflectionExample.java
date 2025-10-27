package com.improvemyskills.javaavance.discovery;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        System.out.println("Méthodes de ArrayList:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}
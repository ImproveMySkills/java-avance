package com.improvemyskills.javaavance.classloaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClassLoader extends ClassLoader {

    private final Path classesDir;

    public MyClassLoader(Path classesDir) {
        this.classesDir = classesDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // Construire le chemin du fichier .class
            String fileName = name.replace('.', '/') + ".class";
            Path classFile = classesDir.resolve(fileName);

            // Lire les octets du fichier
            byte[] classBytes = Files.readAllBytes(classFile);

            // Définir la classe dans la JVM
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Impossible de charger la classe : " + name, e);
        }
    }

    public static void main(String[] args) throws Exception {
        //Path path = Path.of("/chemin/vers/classes");
        Path path = Path.of("src/main/java/com/improvemyskills/javaavance/classloaders/Customer.java");
        MyClassLoader loader = new MyClassLoader(path);

        // Charger la classe dynamiquement
        //Class<?> clazz = loader.loadClass("com.example.MyClass");
        Class<?> clazz = loader.loadClass("com.improvemyskills.javaavance.classloaders.Customer");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Classe chargée : " + clazz.getName());
    }
}
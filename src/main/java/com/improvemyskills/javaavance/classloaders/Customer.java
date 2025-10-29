package com.improvemyskills.javaavance.classloaders;

public class Customer {
    String name;
    String email;

    public Customer() {
    }
    Customer(String name, String email) { this.name = name; this.email = email; }
    @Override public String toString() { return name + " <" + email + ">"; }
}

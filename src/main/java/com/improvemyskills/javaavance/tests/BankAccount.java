package com.improvemyskills.javaavance.tests;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Fonds insuffisants.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
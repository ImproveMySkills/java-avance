package com.improvemyskills.javaavance;


import com.improvemyskills.javaavance.tests.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalanceThrows() {
        BankAccount account = new BankAccount();
        account.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
    }


    @ParameterizedTest
    @ValueSource(doubles = {50.0, 100.0, 200.5})
    void testDepositWithVariousAmounts(double amount) {
        BankAccount account = new BankAccount();
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }


    @ParameterizedTest
    @CsvSource({
            "100, 40, 60",
            "200, 50, 150",
            "150, 150, 0"
    })
    void testWithdrawWithVariousAmounts(double deposit, double withdraw, double expectedBalance) {
        BankAccount account = new BankAccount();
        account.deposit(deposit);
        account.withdraw(withdraw);
        assertEquals(expectedBalance, account.getBalance());
    }


    @ParameterizedTest
    @ValueSource(doubles = {100, 200, 300})
    void testWithdrawMoreThanBalanceThrows(double withdrawAmount) {
        BankAccount account = new BankAccount();
        account.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(withdrawAmount);
        });
    }


    static Stream<Double> depositAmounts() {
        return Stream.of(50.0, 100.0, 250.5, 1000.0);
    }

    @ParameterizedTest
    @MethodSource("depositAmounts")
    void testDeposit(double amount) {
        BankAccount account = new BankAccount();
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }


    static Stream<Arguments> withdrawScenarios() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(100.0, 40.0, 60.0),
                org.junit.jupiter.params.provider.Arguments.of(200.0, 50.0, 150.0),
                org.junit.jupiter.params.provider.Arguments.of(150.0, 150.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("withdrawScenarios")
    void testWithdraw(double deposit, double withdraw, double expectedBalance) {
        BankAccount account = new BankAccount();
        account.deposit(deposit);
        account.withdraw(withdraw);
        assertEquals(expectedBalance, account.getBalance());
    }

}
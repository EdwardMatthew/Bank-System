package com.company;

public class Account {
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt) {
        if (balance > 0) {
            balance -= amt;
            return true;
        }
        return false;
    }
}

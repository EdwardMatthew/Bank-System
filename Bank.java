package com.company;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private int numberOfCustomer;
    private String bankName;

    public Bank() {
    }

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
        numberOfCustomer++;
    }

    public int getNumOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

}

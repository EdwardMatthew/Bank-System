package com.company;
import java.util.Scanner;

// one customer one account system
public class Driver {

    // the simplest menu system possible
    public static void main(String[] args) {
        // initializing all of the pre-req
        Scanner sc = new Scanner(System.in);
        Bank b1 = new Bank();
        int ch, choice, num;

        // making the interactive menu
        System.out.println("WELCOME TO THE BANKING SYSTEM");
        System.out.println("=============================");
        System.out.println("1. Make a new account");
        System.out.println("2. Login to existing account");
        System.out.println("3. Quit");

        do {
            System.out.println(b1.getNumOfCustomer());
            System.out.print("Enter your choice here: ");
            ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter your first name: ");
                    String firstname = sc.next();
                    System.out.print("Enter your last name: ");
                    String lastname = sc.next();
                    System.out.print("Set initial balance (can't be less than 10000): ");
                    int init_bal = sc.nextInt();

                    // adding the customer and the accounts
                    Account a1 = new Account();
                    if (init_bal >= 10000)
                        a1.deposit(init_bal);
                    b1.addCustomer(firstname, lastname);
                    b1.getCustomer(0).setAccount(a1);
                    System.out.println("Account created!");
                    break;
                case 2:
                    for(int i = 0; i < b1.getNumOfCustomer(); i++) {
                        System.out.printf("%d. " + b1.getCustomer(i).getFirstName() +
                                " " + b1.getCustomer(i).getLastName() + "%n", (i + 1));
                    }
                    System.out.print("Enter index of account you want to access: ");
                    num = sc.nextInt();

                    // monetary menu
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Quit");

                    do {
                        System.out.print("Enter your choice here: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter the amount you want to deposit here: ");
                                int dep_bal = sc.nextInt();
                                b1.getCustomer(num - 1).getAccount().deposit(dep_bal);
                                System.out.println("Deposit success!");
                                break;
                            case 2:
                                System.out.print("Enter the amount you want to withdraw here: ");
                                int with_bal = sc.nextInt();
                                b1.getCustomer(num - 1).getAccount().withdraw(with_bal);
                                System.out.println("Withdrawal success!");
                                break;
                            case 3:
                                System.out.print("The current balance is: ");
                                System.out.println(b1.getCustomer(num - 1).getAccount().getBalance());
                                break;
                            case 4:
                                System.out.println("GOING BACK TO THE MAIN BANK MENU...");
                                break;
                        }
                    } while (choice != 4);
                    break;

            case 3:
                System.out.println("Program exited. Have a nice day!");
                break;
            }
        } while (ch != 3);
    }
}
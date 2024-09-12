package org.rts;

import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.00; // Starting balance for the user

        while (true) {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + balance);
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("You have successfully deposited $" + depositAmount);
                        System.out.println("Your new balance is: $" + balance);
                    } else {
                        System.out.println("Invalid deposit amount. Please try again.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("You have successfully withdrawn $" + withdrawAmount);
                        System.out.println("Your new balance is: $" + balance);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance. Please try a smaller amount.");
                    } else {
                        System.out.println("Invalid withdrawal amount. Please try again.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

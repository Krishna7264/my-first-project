package org.rts;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects = 0;

        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numberOfSubjects = scanner.nextInt();
                if (numberOfSubjects > 0) {
                    break;  // Valid input, exit loop
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear the invalid input
            }
        }

        double[] scores = new double[numberOfSubjects];
        double total = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            while (true) {
                System.out.print("Enter the score for subject " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    double score = scanner.nextDouble();
                    if (score >= 0 && score <= 100) {  // Assuming scores are between 0 and 100
                        scores[i] = score;
                        total += scores[i];
                        break;
                    } else {
                        System.out.println("Please enter a score between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid score.");
                    scanner.next();  // Clear the invalid input
                }
            }
        }

        double average = total / numberOfSubjects;

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nTotal Score: " + total);
        System.out.println("Average Score: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

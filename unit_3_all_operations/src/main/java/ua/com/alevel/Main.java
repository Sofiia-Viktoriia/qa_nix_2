package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            System.out.println("\nPlease, choose the option:\n0 - Exit\n1 - Task 1 (Sum of numbers in the string)\n2 - Task 2 (Amount of letters in the string)\n3 - Task 3 (School schedule)\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice) {
                case 0 : {
                    System.out.println("Exiting...");
                } break;
                case 1 : {
                    new SumOfNumbers().run();
                } break;
                case 2 : {
                    new AmountOfLetters().run();
                } break;
                case 3 : {
                    new SchoolSchedule().run();
                } break;
                default : {
                    System.out.println("Please, choose the option from the menu.");
                }
            }
        }
    }
}

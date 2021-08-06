package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            System.out.println("\nPlease, choose the option:\n0 - Exit\n1 - Simple reverse\n2 - Reverse with substring\n3 - Reverse with indexes\n");
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

                } break;
                case 2 : {

                } break;
                case 3 : {

                } break;
                default : {
                    System.out.println("Please, choose the option from the menu.");
                }
            }
        }
    }
}

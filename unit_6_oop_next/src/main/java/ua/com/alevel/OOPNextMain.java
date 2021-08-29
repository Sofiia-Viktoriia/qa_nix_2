package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OOPNextMain {

    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            System.out.println("\nPlease, choose the planet which acceleration of gravity you want to see:\n0 - Exit\n1 - Mercury\n2 - Venus\n3 - Earth\n4 - Mars\n5 - Jupiter\n6 - Saturn\n7 - Uranus\n8 - Neptune\n9 - All planets\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            PlanetReporter planetReporter = new PlanetReporter();
            switch (choice) {
                case 0: {
                    System.out.println("Exiting...");
                }
                break;
                case 1: {
                    planetReporter.printAccelerationOfGravity(1);
                }
                break;
                case 2: {
                    planetReporter.printAccelerationOfGravity(2);
                }
                break;
                case 3: {
                    planetReporter.printAccelerationOfGravity(3);
                }
                break;
                case 4: {
                    planetReporter.printAccelerationOfGravity(4);
                }
                break;
                case 5: {
                    planetReporter.printAccelerationOfGravity(5);
                }
                break;
                case 6: {
                    planetReporter.printAccelerationOfGravity(6);
                }
                break;
                case 7: {
                    planetReporter.printAccelerationOfGravity(7);
                }
                break;
                case 8: {
                    planetReporter.printAccelerationOfGravity(8);
                }
                break;
                case 9: {
                    planetReporter.printAccelerationOfGravity(9);
                }
                break;
                default: {
                    System.out.println("Please, choose the option from the menu.");
                }
            }
        }
    }
}

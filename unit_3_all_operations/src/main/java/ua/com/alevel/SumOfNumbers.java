package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers {
    public void run() {
        System.out.println("\nPlease, enter the string");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = "";
        try {
            message = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] chars = message.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            int num = aChar;
            if (num >= 48 && num < 58) {
                sum += num - 48;
            }
        }
        System.out.println("Sum of the numbers: " + sum + "\n");
    }
}

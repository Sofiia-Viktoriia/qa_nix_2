package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class AmountOfLetters {
    public void run() {
        System.out.println("\nPlease, enter the string");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = "";
        try {
            message = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message = message.toLowerCase();
        char[] chars = message.toCharArray();
        int[] alphabet = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i];
            if (num >= 97 && num < 123) {
                alphabet[num - 97] ++;
            }
        }
        int counter = 1;
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] > 0) {
                System.out.println(counter + ". " + (char)(i + 97) + " - " + alphabet[i]);
                counter++;
            }
        }
    }
}

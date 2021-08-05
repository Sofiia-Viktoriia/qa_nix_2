package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        char[] chars = message.toCharArray();
        int[] alphabet = new int[26];
        int[] alphabetBig = new int[26];
        int[] alphabetKiril = new int[33];
        int[] alphabetKirilBig = new int[33];
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i];
            if (num >= 97 && num < 123) {
                alphabet[num - 97]++;
            } else if (num >= 65 && num < 91) {
                alphabetBig[num - 65]++;
            } else if (num >= 1040 && num < 1072) {
                alphabetKirilBig[num - 1040]++;
            } else if (num >= 1072 && num < 1104) {
                alphabetKiril[num - 1072]++;
            } else if (num == 1025) {
                alphabetKirilBig[32]++;
            } else if (num == 1105) {
                alphabetKiril[32]++;
            }
        }
        int counter = 1;
        for (int i = 0; i < alphabetBig.length; i++) {
            if(alphabetBig[i] > 0) {
                System.out.println(counter + ". " + (char)(i + 65) + " - " + alphabetBig[i]);
                counter++;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                System.out.println(counter + ". " + (char) (i + 97) + " - " + alphabet[i]);
                counter++;
            }
        }
        for (int i = 0; i < alphabetKirilBig.length - 1; i++) {
            if (alphabetKirilBig[i] > 0) {
                System.out.println(counter + ". " + (char) (i + 1040) + " - " + alphabetKirilBig[i]);
                counter++;
                if (i == 5 && alphabetKirilBig[32] > 0) {
                    System.out.println(counter + ". " + (char) (1025) + " - " + alphabetKirilBig[32]);
                    counter++;
                }
            }
        }
        for (int i = 0; i < alphabetKiril.length - 1; i++) {
            if (alphabetKiril[i] > 0) {
                System.out.println(counter + ". " + (char) (i + 1072) + " - " + alphabetKiril[i]);
                counter++;
                if (i == 5 && alphabetKiril[32] > 0) {
                    System.out.println(counter + ". " + (char) (1105) + " - " + alphabetKiril[32]);
                    counter++;
                }
            }
        }
    }
}

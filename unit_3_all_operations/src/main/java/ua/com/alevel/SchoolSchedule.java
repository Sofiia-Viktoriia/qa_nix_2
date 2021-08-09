package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolSchedule {

    public void run() {
        int subject = 0;
        System.out.println("Please, enter the number of subject");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            subject = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (subject > 0 && subject < 11) {
            int x = subject / 2; // количество перемен после нечетных уроков
            int y = subject - x - 1; // количество перемен после четных уроков
            int minutes = (subject * 45) + (x * 5) + (y * 15);
            int hours = minutes / 60 + 9;
            minutes = minutes % 60;
            System.out.println("Time of the end: " + hours + " " + minutes);
        } else {
            System.out.println("Please, enter the number from 1 to 10");
        }

    }
}

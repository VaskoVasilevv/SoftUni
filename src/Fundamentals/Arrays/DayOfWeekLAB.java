package Fundamentals.Arrays;

import java.util.Scanner;

public class DayOfWeekLAB {
    public static void main(String[] args) {
        String[] daysOFWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = new Scanner(System.in).nextInt();
        if (day >= 1 && day <= 7) {
            System.out.println(daysOFWeek[day - 1]);
        }else {
            System.out.println("Invalid day!");
        }
    }
}

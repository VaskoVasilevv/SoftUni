package Fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class UnixEpochTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int year = new Scanner(System.in).nextInt();

        int unixEpoch = 1970;

        int yearsPassed = year - unixEpoch;

        System.out.println(yearsPassed);

        final int secoundInYear = 365 * 24 * 60 * 60;

        long epochTime = (long) yearsPassed * secoundInYear; // cnt alt enter suzdawane na promenliva
        System.out.println(epochTime);
    }
}
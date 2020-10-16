package bg.softuni.fundamentals.Data.Types;

import java.util.Scanner;

public class CenturesToMinutesLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = Integer.parseInt(scanner.nextLine());
        int century = i * 100;
        int day = (int) (century * 365.2422);
        int houers = day * 24;
        int minutes = houers * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes",i,century,day,houers,minutes);
    }
}

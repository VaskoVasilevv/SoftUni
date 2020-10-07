package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int houers = scanner.nextInt();
        int minutes = scanner.nextInt();

        minutes += 30;
        if (minutes >= 60) {
            minutes -= 60;
            houers++;
            if (houers >= 24) {
                houers -= 24;
            }
        }
        System.out.printf("%d:%02d", houers, minutes);
    }
}

package bg.softuni.fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03SizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("#"))
                .collect(Collectors.toList());

        double effort = 0;
        int totalFire = 0;

        int water = Integer.parseInt(scanner.nextLine());
        System.out.println("Cells:");
        for (int i = 0; i < list.size(); i++) {
            String[] tokens = list.get(i).split(" = ");
            String battery = tokens[0];
            int level = Integer.parseInt(tokens[1]);
            if (battery.equals("High") && level <= 125 && level >= 81 && water >= level) {
                water -= level;
                effort += level * 0.25;
                totalFire += level;

                System.out.printf(" - %d%n", level);
            } else if (battery.equals("Medium") && level <= 80 && level >= 51 && water >= level) {
                water -= level;
                effort += level * 0.25;
                totalFire += level;

                System.out.printf(" - %d%n", level);
            } else if (battery.equals("Low") && level <= 50 && level >= 1 && water >= level) {
                water -= level;
                effort += level * 0.25;
                totalFire += level;

                System.out.printf(" - %d%n", level);
            }
        }
        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", totalFire);
    }
}

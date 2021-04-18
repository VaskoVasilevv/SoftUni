package Fundamentals.Data.Types;

import java.util.Scanner;

public class TownInfoLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.",city,population,people);
    }
}

package ProgrammingBasics.Exam;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String breed = scanner.nextLine();
        String gender = scanner.nextLine();
        double catYears = 0;
        boolean check = false;

        switch (breed) {
            case "British Shorthair":
                if(gender.equals("m")) {
                    catYears = 13;
                }
                else if(gender.equals("f")) {
                    catYears = 14;
                }
                break;
            case "Siamese":
                if (gender.equals("m"))
                {
                    catYears = 15;
                }
                else if (gender.equals("f"))
                {
                    catYears = 16;
                }
                break;
            case "Persian":
                if (gender.equals("m"))
                {
                    catYears = 14;
                }
                else if (gender.equals("f"))
                {
                    catYears = 15;
                }
                break;
            case "Ragdoll":
                if (gender.equals("m"))
                {
                    catYears = 16;
                }
                else if (gender.equals("f"))
                {
                    catYears = 17;
                }
                break;
            case "American Shorthair":
                if (gender.equals("m"))
                {
                    catYears = 12;
                }
                else if (gender.equals("f"))
                {
                    catYears = 13;
                }
                break;
            case "Siberian":
                if (gender.equals("m"))
                {
                    catYears = 11;
                }
                else if (gender.equals("f"))
                {
                    catYears = 12;
                }
                break;
            default:
                System.out.printf("%s is invalid cat!",breed);
                check = true;
                break;
        }

        if (!check) {
            double catMonths = (catYears * 12) / 6;
            System.out.printf("%.0f cat months", catMonths);
        }


    }
}

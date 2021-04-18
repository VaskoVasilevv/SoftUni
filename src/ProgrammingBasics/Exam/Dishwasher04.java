package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Dishwasher04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottle = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        bottle *= 750;
        int counter = 0;
        int dishes = 0;
        int tendjera = 0;
        boolean flag = false;
        while (!input.equals("End")) {
            int izmitiBottle = Integer.parseInt(input);
            counter++;
            if (counter % 3 == 0) {
                tendjera += izmitiBottle;
                bottle -= izmitiBottle * 15;
            } else {
                bottle -= izmitiBottle * 5;
                dishes += izmitiBottle;
            }
            if (bottle < 0) {
                flag = true;
                break;
            }


            input = scanner.nextLine();
        }
        if (flag) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(bottle));
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", dishes, tendjera);
            System.out.printf("Leftover detergent %d ml.", bottle);
        }

    }
}

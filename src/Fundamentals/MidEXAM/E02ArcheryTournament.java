package Fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.Scanner;

public class E02ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] field = Arrays.stream(scanner.nextLine().split("\\|"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int sum = 0;
        while (!input.equals("Game over")) {
            String[] tokens = input.split("@");
            String command = tokens[0];

            switch (command) {
                case "Shoot Left":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < field.length) {
                        int targetIndexLeft = index - length;
                        while (targetIndexLeft < 0) {
                            targetIndexLeft = field.length + targetIndexLeft;
                        }
                        if (field[targetIndexLeft] >= 5) {
                            field[targetIndexLeft] -= 5;
                            sum += 5;
                        } else {
                            sum += field[targetIndexLeft];
                            field[targetIndexLeft] = 0;
                        }
                    }
                    break;
                case "Shoot Right":
                    index = Integer.parseInt(tokens[1]);
                    length = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < field.length) {
                        int targetIndexRight = index + length;
                        while (targetIndexRight >= field.length) {
                            targetIndexRight = targetIndexRight - field.length;
                        }
                        if (field[targetIndexRight] >= 5) {
                            field[targetIndexRight] -= 5;
                            sum += 5;
                        } else {
                            sum += field[targetIndexRight];
                            field[targetIndexRight] = 0;
                        }
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < field.length / 2; i++) {
                        int oldField = field[i];
                        field[i] = field[field.length - 1 - i];
                        field[field.length - 1 - i] = oldField;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < field.length - 1; i++) {
            System.out.print(field[i] + " - ");
        }
        System.out.println(field[field.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!", sum);
    }
}

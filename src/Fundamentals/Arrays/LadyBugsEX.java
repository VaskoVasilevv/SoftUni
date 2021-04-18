package Fundamentals.Arrays;

import java.util.Scanner;

public class LadyBugsEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] field = new int[n];
        String[] bugIndexes = scanner.nextLine().split(" ");

        for (int i = 0; i < bugIndexes.length; i++) {
            int bugIndex = Integer.parseInt(bugIndexes[i]);

            if (bugIndex >= 0 && bugIndex < field.length) {
                field[bugIndex] = 1;
            }
        }
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String [] comands = line.split(" ");
            int bugIndex = Integer.parseInt(comands[0]);
            String direction = comands[1];
            int length = Integer.parseInt(comands[2]);

            if (bugIndex < 0 || bugIndex >= field.length || field[bugIndex] != 1){
                line = scanner.nextLine();
                continue;
            }

            field[bugIndex] = 0;

            if (direction.equals("right")){
                bugIndex += length;
                while (bugIndex < field.length && field[bugIndex] == 1){
                    bugIndex += length;
                }
                if (bugIndex < field.length){
                    field[bugIndex] = 1;
                }
            }else {
                bugIndex -= length;

                while (bugIndex >= 0 && field[bugIndex] == 1){
                    bugIndex -= length;
                }

                if (bugIndex >= 0){
                    field[bugIndex] = 1;

                }
            }

            line = scanner.nextLine();
        }
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");

        }
    }
}

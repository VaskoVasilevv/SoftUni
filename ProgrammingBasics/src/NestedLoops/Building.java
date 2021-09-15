package NestedLoops;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int f = flors; f >= 1; f--) {
            for (int r = 0; r < rooms; r++) {

                if (f == flors) {
                    System.out.printf("L%d%d ", f, r);
                }else if (f % 2 == 0) {
                    System.out.printf("O%d%d ", f, r);
                } else {
                    System.out.printf("A%d%d ", f, r);
                }
            }
            System.out.println();
        }
    }
}

package Exam;

import java.util.Scanner;

public class EasterBake05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggs = Integer.parseInt(scanner.nextLine());
        int red = 0;
        int orange = 0;
        int blue = 0;
        int green = 0;
        int max = Integer.MIN_VALUE;
        String maxColor = "";
        for (int i = 1; i <= eggs; i++) {
            String color = scanner.nextLine();

            switch (color) {
                case "red":
                    red++;
                    if (max < red) {
                        max = red;
                        maxColor = "red";
                    }
                    break;
                case "orange":
                    orange++;
                    if (max < orange) {
                        max = orange;
                        maxColor = "orange";
                    }
                    break;
                case "blue":
                    blue ++;
                    if (max < blue) {
                        max = blue;
                        maxColor = "blue";
                    }
                    break;
                case "green":
                    green++;
                    if (max < green) {
                        max = green;
                        maxColor = "green";
                    }
                    break;
            }

        }
        System.out.printf("Red eggs: %d%n",red);
        System.out.printf("Orange eggs: %d%n",orange);
        System.out.printf("Blue eggs: %d%n",blue);
        System.out.printf("Green eggs: %d%n",green);
        System.out.printf("Max eggs: %d -> %s",max,maxColor);
    }
}

package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class Vaso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] demo = new int[7];

        for (int i = 0; i < demo.length; i++) {
            demo[i] = Integer.parseInt(scanner.nextLine());
        }

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        reverse(demo, start, end);


    }

    public static int[] reverse(int[] demo, int start, int end) {
        if (start >= 0 && end < demo.length) {
            int num = end ;
            for (int i = start; i < end; i++) {
                int temp = demo[i];
                demo[i] = demo[num];
                demo[num] = temp;
                num --;
            }
        }
        return demo;
    }
}

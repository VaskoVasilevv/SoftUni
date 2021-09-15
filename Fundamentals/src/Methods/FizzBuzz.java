package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());
        System.out.print((Arrays.toString(fizzBuzz(end))));
    }

    public static String [] fizzBuzz( int end) {
        String [] arr = new String[end - 1];
        for (int i = 1; i < end; i++) {
            if (i % 3 == 0) {
                arr [i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                arr[i -1] = "Buzz";
            }else {
                arr [i-1] = String.valueOf(i);
            }
        }
        return arr;
    }

}




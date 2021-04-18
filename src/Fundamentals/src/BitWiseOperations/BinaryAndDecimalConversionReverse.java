package BitWiseOperations;

import java.util.Scanner;

public class BinaryAndDecimalConversionReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 71;
        String result = "";

        while (num > 0) {
            int d = num % 2;
            result = d + result;
            num = num / 2;
        }
        System.out.println(result);
    }
}

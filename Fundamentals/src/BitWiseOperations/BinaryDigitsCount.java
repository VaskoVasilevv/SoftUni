package BitWiseOperations;

import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String result = "";
        int b = 1;
        int cout = 0;

        while (num > 0) {
            int d = num % 2;
            result = d + result;
            num = num / 2;
            if (b == d){
                cout++;
            }
        }
        System.out.println(cout);
    }
}

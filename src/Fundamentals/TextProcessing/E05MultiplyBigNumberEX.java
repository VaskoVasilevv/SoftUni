package Fundamentals.TextProcessing;

import java.util.Scanner;

public class E05MultiplyBigNumberEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        int second = Integer.parseInt(scanner.nextLine());

        if (second == 0){
            System.out.println(0);
            return;
        }
        StringBuilder big = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            int num = Integer.parseInt(String.valueOf(first.charAt(i)));
            if (num != 0){
                big.append(num);
            }

        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = big.length()-1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(big.charAt(i)));
            int result = digit * second + carry;

            if (i == 0){
                sb.insert(0,result);
            }else {
                int resDigit = result % 10;
                carry = result / 10;
                sb.insert(0, resDigit);
            }
        }

        System.out.println(sb);
    }
}

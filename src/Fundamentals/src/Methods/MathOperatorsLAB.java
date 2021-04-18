package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperatorsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(calculate(first,operator,second)));
    }

    public static double calculate(int a, String operator, int b) {
        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result =(double) a / b;
                break;
            case "*":
                result = a * b;
                break;
        }
        return result;
    }
}

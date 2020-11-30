package bg.softuni.fundamentals.Methods;

public class Fibonacci {
    public static void main(String[] args) {
        int x = fibonacci(4);
        System.out.println(x);

    }

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

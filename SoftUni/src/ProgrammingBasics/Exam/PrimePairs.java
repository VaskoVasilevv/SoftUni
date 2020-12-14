import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        for (int i = a; i <= a + c; i++) {
            for (int j = b; j <= b + d; j++) {
                if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0 && j % 2 != 0 && j % 3 != 0 && j % 5 != 0 && j % 7 != 0) {
                    System.out.printf("%d%d%n", i, j);
                }
            }

        }

    }
}

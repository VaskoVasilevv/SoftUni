import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double average = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            average += num;

        }
        double sum = average / n;
        System.out.printf("%.2f",sum);
    }
}

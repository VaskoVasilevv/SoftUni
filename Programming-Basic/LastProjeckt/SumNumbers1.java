import java.util.Scanner;

public class SumNumbers1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;

        while (!input.equals("Stop")){
            int num = Integer.parseInt(input);
            sum += num;

            input = scanner.nextLine();
        }
        System.out.println(sum);
    }
}

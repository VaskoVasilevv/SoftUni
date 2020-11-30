import java.util.Scanner;

public class Ku4eta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double fooddog = Double.parseDouble(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double a = fooddog * 2.5;
        int b = food * 4;
        double result = a + b;

        System.out.printf("%.2f.lv", result);



    }
}

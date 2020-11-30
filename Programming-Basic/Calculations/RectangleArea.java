import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());

        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);
        double area = a * b;
        double perimeter = 2 * (a + b);

        System.out.printf("%.2f%n", area);
        System.out.printf("%.2f", perimeter);

    }
}

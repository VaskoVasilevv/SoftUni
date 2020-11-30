import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double area = 0;

        if (input.equals("square")){
            double side = Double.parseDouble(scanner.nextLine());
            area = side * side;
        } else if (input.equals("rectangle")){
            double firstSide = Double.parseDouble(scanner.nextLine());
            double secondSide = Double.parseDouble(scanner.nextLine());

            area = firstSide * secondSide;

        }else if (input.equals("circle")){
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * radius * radius;

        }else if (input.equals("triangle")){
            double side = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());

            area = (side * height) / 2;
        }

        System.out.printf("%.3f",area);
    }
}

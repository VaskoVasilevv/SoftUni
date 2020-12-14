package bg.softuni.fundamentals.Methods;

import java.util.Scanner;

public class CalculateReactingAreaLAB {
    static double getArea (double width,double height){
        return width * height;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double area = getArea(width,height);
        System.out.printf("%.0f",area);

    }
}

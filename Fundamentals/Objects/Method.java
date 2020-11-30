package bg.softuni.fundamentals.Objects;

import java.util.Scanner;

public class Method {
    static class Circle {
        double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        double getArea() {
            return radius * radius * Math.PI;
        }

        void scale(double factor) {
            radius *= factor;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle c = new Circle(Integer.parseInt(scanner.nextLine()));


        System.out.println(c.getArea());
    }
}

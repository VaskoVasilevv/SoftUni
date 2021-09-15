package Exam;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int salary = Integer.parseInt(scanner.nextLine());
        double water = 0;
        double internet = 0;
        double other = 0;
        double electricity1 = 0;

        for (int i = 1; i <= salary ; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            electricity1 += electricity;
            water += 20;
            internet += 15;
            other += (electricity + 20 + 15) * 1.2 ;
        }
        double average = (internet + water + electricity1 + other)/ salary;
        System.out.printf("Electricity: %.2f lv%n",electricity1);
        System.out.printf("Water: %.2f lv%n",water);
        System.out.printf("Internet: %.2f lv%n",internet);
        System.out.printf("Other: %.2f lv%n",other);
        System.out.printf("Average: %.2f lv",average);
    }
}

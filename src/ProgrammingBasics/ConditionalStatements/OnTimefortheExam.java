package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class OnTimefortheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHours = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHours = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int totalExamTime = (examHours * 60) + examMinutes;
        int totalArrivalTime = (arrivalHours * 60) + arrivalMinutes;
        int totalDiff = Math.abs(totalExamTime - totalArrivalTime);
        int totalHour = totalDiff / 60;
        int totalMinute = totalDiff % 60;
        if (totalExamTime < totalArrivalTime) {
            if (totalDiff <= 59) {
                System.out.println("Late");
                System.out.printf("%d minutes after the start", totalDiff);
            } else if (totalDiff >= 60) {
                if (totalMinute <= 9) {
                    System.out.println("Late");
                    System.out.printf("%d:0%d hours after the start", totalHour, totalMinute);
                } else {
                    System.out.println("Late");
                    System.out.printf("%d:%d hours after the start", totalHour, totalMinute);
                }
            }
        } else if (totalArrivalTime <= totalExamTime && totalDiff <= 30) {
            if (totalDiff <= 59 && totalDiff != 0) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", totalDiff);
            } else if (totalDiff == 0) {
                System.out.println("On time");
            }
        } else if (totalArrivalTime < totalExamTime && totalDiff > 30) {
            if (totalDiff <= 59) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", totalDiff);
            } else if (totalDiff >= 60) {
                if (totalMinute <= 9) {
                    System.out.println("Early");
                    System.out.printf("%d:0%d hours before the start", totalHour, totalMinute);
                } else {
                    System.out.println("Early");
                    System.out.printf("%d:%d hours before the start", totalHour, totalMinute);
                }
            }
        }
    }
}

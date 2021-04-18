package ProgrammingBasics.Exam;

import java.util.Scanner;

public class UmOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int begine = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int combination = 0;
        boolean flag = false;

        for (int i = begine; i <= end ; i++) {
            for (int j = begine; j <= end ; j++) {
                combination ++;
                int sum = i + j;

                if (i + j == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)%n",combination,i , j,sum);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        if (!flag){
            System.out.printf("%d combinations - neither equals %d", combination, magicNum);
        }
    }
}

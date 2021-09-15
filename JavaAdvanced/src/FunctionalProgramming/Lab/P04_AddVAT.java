package FunctionalProgramming.Lab;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P04_AddVAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();

        switch (input) {
            case "even":
                IntStream.range(num[0],num[1]+1).filter(n->n%2==0)
                        .forEach(e-> System.out.print(e +" "));
                break;
            case "odd":
                IntStream.range(num[0],num[1]+1).filter(n->n%2!=0)
                        .forEach(e-> System.out.print(e +" "));
                break;
        }


    }
}

package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class Uprajnenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int numberOfBooks = Integer.parseInt(scanner.nextLine());
        int chekedBooks = 0;
        boolean isFound = false;


        while (numberOfBooks > chekedBooks){
            String nameOfBokk = scanner.nextLine();

            if (name.equals(nameOfBokk)){
                isFound = true;
                break;
            }
            chekedBooks++;
        }
        if (isFound){
            System.out.printf("You checked %d books and found it.",chekedBooks);
        }else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", chekedBooks);
        }
    }
}


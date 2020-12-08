package bg.softuni.fundamentals.FinalExam;


import java.util.*;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s");
            switch (tokens[0]) {
                case "TakeOdd":
                    StringBuilder string = new StringBuilder();
                    for (int i = 1; i < sb.length(); i += 2) {
                        string.append(sb.charAt(i));
                    }
                    sb = string;
                    System.out.println(sb);
                    break;
                case "Cut":
                    int length = Integer.parseInt(tokens[2]);
                    int index = Integer.parseInt(tokens[1]);

                    sb.replace(index, index + length, "");
                    System.out.println(sb);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitude = tokens[2];

                    if (sb.indexOf(substring) != -1) {
                        sb = new StringBuilder(sb.toString().replace(substring, substitude));
                        System.out.println(sb);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s",sb);
    }
}

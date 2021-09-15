package FinalExam;

import java.util.Scanner;

public class E01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String commands = scanner.nextLine();
        while (!commands.equals("Travel")) {
            String[] tokens = commands.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    if (index >= 0 && index < sb.length()){
                        sb.insert(index,string);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < sb.length()  && endIndex >= 0 && endIndex < sb.length()){
                        sb.replace(startIndex,endIndex + 1,"");
                    }
                    break;
                case "Switch":
                    String old = tokens[1];
                    String newString = tokens[2];
                    sb = new StringBuilder(sb.toString().replace(old,newString));
                    break;
            }
            System.out.println(sb);
            commands = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + sb );
    }
}


package bg.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class E01AprilActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKeys = new StringBuilder(scanner.nextLine());
        String tokens = scanner.nextLine();
        while (!tokens.equals("Generate")) {
            String[] commands = tokens.split(">>>");
            switch (commands[0]) {
                case "Contains":
                    String def = commands[1];
                    if (activationKeys.indexOf(def) != -1) {
                        System.out.printf("%s contains %s%n", activationKeys, commands[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String comand = commands[1];
                    switch (comand) {
                        case "Upper":
                            int strartIndex = Integer.parseInt((commands[2])) ;
                            int endIndex = Integer.parseInt((commands[3]));
                            String end = activationKeys.substring(strartIndex ,endIndex).toUpperCase();
                            activationKeys.replace(strartIndex,endIndex,end);
                            System.out.println(activationKeys);
                            break;
                        case "Lower":
                            strartIndex = Integer.parseInt((commands[2])) ;
                            endIndex = Integer.parseInt((commands[3]));
                            end = activationKeys.substring(strartIndex ,endIndex).toLowerCase();
                            activationKeys.replace(strartIndex,endIndex,end);
                            System.out.println(activationKeys);
                            break;
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt((commands[1])) ;
                    int endIndex = Integer.parseInt((commands[2]));
                    activationKeys.delete(startIndex,endIndex);
                    System.out.println(activationKeys);
                    break;
            }

            tokens = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKeys);
    }
}

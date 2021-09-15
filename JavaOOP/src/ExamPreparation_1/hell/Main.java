package ExamPreparation_1.hell;


import ExamPreparation_1.hell.interfaces.Manager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new ManagerImpl();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Quit")) {
            String[] commandArgs = commandLine.split(" ");
            String commandName = commandArgs[0];
            String result = "";
            switch (commandName) {
                case "Hero":
                    result = manager.addHero
                            (Arrays.asList(commandArgs[1], commandArgs[2]));
                    break;
                case "Item":
                    result = manager.addItem
                            (Arrays.asList(commandArgs));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(commandArgs));
                    break;
                case "Inspect":
                    result = manager.inspect(Arrays.asList(commandArgs));
                    break;

            }

            System.out.println(result);


            commandLine = scanner.nextLine();
        }
        System.out.println(manager.quit());
    }

}
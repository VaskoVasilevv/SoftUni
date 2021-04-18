package FinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> composer = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String name = input[1];
            String piece = input[0];
            String key = input[2];

            composer.put(piece, new String[]{key, name});
        }
        String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {
            String[] tokens = commands.split("\\|");
            switch (tokens[0]) {
                case "Add":
                    String piece = tokens[1];
                    String name = tokens[2];
                    String key = tokens[3];
                    if (composer.containsKey(piece)){
                        System.out.println(piece + " is already in the collection!");
                    }else {
                        composer.put(piece,new String[]{key,name});
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,name,key);
                    }
                    break;
                case "Remove":
                    piece = tokens[1];
                    if (composer.containsKey(piece)){
                        composer.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
                case "ChangeKey":
                    piece = tokens[1];
                    key = tokens[2];
                    if (composer.containsKey(piece)){
                        composer.get(piece)[0] = key;
                        System.out.printf("Changed the key of %s to %s!%n",piece,key);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        composer.entrySet().stream().forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n",e.getKey(),e.getValue()[1],e.getValue()[0]));
    }
}

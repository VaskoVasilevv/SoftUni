package FinalExam;

import java.util.*;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> users = new TreeMap<>();

        String input = scanner.nextLine();

        int counter = 0;
        while (!input.equals("Statistics")) {
            String[] commands = input.split("=");
            String name = commands[1];
            boolean flag = false;
            switch (commands[0]) {
                case "Add":
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);
                    users.putIfAbsent(name, new int[]{sent, received});
                    break;
                case "Message":
                    String sender = commands[1];
                    String receiver = commands[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        users.get(sender)[0]++;
                        users.get(receiver)[1]++;
                        if (users.get(sender)[0] + users.get(sender)[1] >= capacity) {
                            System.out.println(sender + " reached the capacity!");
                            users.remove(sender);

                        }
                        if (users.get(receiver)[0] + users.get(receiver)[1] >= capacity) {
                            System.out.println(receiver + " reached the capacity!");
                            users.remove(receiver);

                        }
                    }
                    break;
                case "Empty":
                    String token = commands[1];
                    if (token.equals("All")) {
                        users.clear();
                    } else {
                        users.remove(token);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Users count: " + users.size());
        users.entrySet().stream()
                .sorted((f, s) -> {
                    int sumFirst = f.getValue()[1];
                    int sumSecond = s.getValue()[1];
                    return  sumSecond - sumFirst;
                }).forEach(e -> System.out.println(e.getKey()+" - " + (e.getValue()[0]+e.getValue()[1])));
    }

}


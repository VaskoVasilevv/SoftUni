package FinalExam;

import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> usersEmails = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Statistics")) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    if (usersEmails.containsKey(username)) {
                        System.out.println(username + " is already registered");
                    } else {
                        usersEmails.put(username, new ArrayList<>());
                    }
                    break;
                case "Send":
                    String email = tokens[2];
                    usersEmails.get(username).add(email);
                    break;
                case "Delete":
                    if (usersEmails.containsKey(username)) {
                        usersEmails.remove(username);
                    } else {
                        System.out.println(username + " not found!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Users count: " + usersEmails.size());
        usersEmails.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue().size() - a.getValue().size();
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    for (String s : e.getValue()) {
                        System.out.println(" - " + s);
                    }

                });
    }
}

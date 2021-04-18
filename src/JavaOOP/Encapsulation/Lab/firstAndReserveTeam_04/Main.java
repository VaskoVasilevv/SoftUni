package JavaOOP.Encapsulation.Lab.firstAndReserveTeam_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Team team = new Team("Black Eagles");
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person p = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));

            team.addPlayer(p);
        }

        System.out.println(String.format("First team %d players", team.getFirstTeam().size()));
        System.out.println(String.format("Reserve team %d players", team.getReserveTeam().size()));
    }
}

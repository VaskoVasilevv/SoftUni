package bg.softuni.fundamentals.FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> heroes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] hero = scanner.nextLine().split("\\s");

            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);
            heroes.put(hero[0], new int[]{hp, mp});
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String heroName = tokens[1];
            int amount = Integer.parseInt(tokens[2]);
            switch (tokens[0]) {
                case "Heal":
                    if (heroes.get(heroName)[0] + amount >= 100) {
                        amount = 100 - heroes.get(heroName)[0];
                    }
                    heroes.get(heroName)[0] += amount;
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
                case "Recharge":
                    if (heroes.get(heroName)[1] + amount > 200) {
                        amount = 200 - heroes.get(heroName)[1];
                    }
                    heroes.get(heroName)[1] += amount;
                    System.out.printf("%s recharged for %d MP!%n",heroName, amount);
                    break;
                case "TakeDamage":
                    String attacker = tokens[3];
                    if (heroes.get(heroName)[0] - amount > 0){
                        heroes.get(heroName)[0] -= amount;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                        ,heroName,amount,attacker,heroes.get(heroName)[0]);
                    }else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                    }
                    break;
                case "CastSpell":
                    String castSpell = tokens[3];
                    if (heroes.get(heroName)[1] >= amount){
                        heroes.get(heroName)[1] -= amount;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                        ,heroName,castSpell,heroes.get(heroName)[1]);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",heroName,castSpell);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        heroes.entrySet().stream()
                .sorted((a,b)->{
                    int result = b.getValue()[0]-a.getValue()[0];
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(h ->{
            System.out.println(h.getKey());
            System.out.printf("  HP: %d%n",h.getValue()[0]);
            System.out.printf("  MP: %d%n",h.getValue()[1]);
        });
    }
}

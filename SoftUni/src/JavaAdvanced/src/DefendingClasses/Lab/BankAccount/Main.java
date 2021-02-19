package DefendingClasses.Lab.BankAccount;

import DefendingClasses.Lab.BankAccount.BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> vault = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String output;
            BankAccount bankAccount;

            switch (tokens[0]) {
                case "Create":
                    bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    if (vault.containsKey(id)) {
                        int amount = Integer.parseInt(tokens[2]);
                        vault.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterest = (tokens.length == 2)
                            ? Double.parseDouble(tokens[1])
                            : Double.parseDouble(tokens[2]);
                    BankAccount.setInterestRate(newInterest);

                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)) {
                        double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f", interest);

                    } else {
                        output = "Account does not exist";

                    }
                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + tokens[0]);
            }
            if (output != null) {
                System.out.println(output);
            }
        }
    }
}

package Fundamentals.FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E03NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String model = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            int[] carsThemselves = new int[]{mileage, fuel};
            cars.put(model, carsThemselves);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String carModel = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if ( fuel >= cars.get(carModel)[1]) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(carModel)[0] += distance;
                        cars.get(carModel)[1] -= fuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",carModel,distance,fuel);
                    }
                    if (cars.get(carModel)[0] >= 100000){
                        System.out.println("Time to sell the " + carModel+"!");
                        cars.remove(carModel);
                    }
                    break;
                case "Refuel":
                    int amount = Integer.parseInt(tokens[2]);
                    if (cars.get(carModel)[1] + amount  >= 75) {
                        amount = 75 - cars.get(carModel)[1];
                    }
                    cars.get(carModel)[1] += amount;
                    System.out.printf("%s refueled with %d liters%n",carModel,amount);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);

                    if (cars.get(carModel)[0] - kilometers < 10000){
                        cars.get(carModel)[0] = 10000;
                    }else {
                        cars.get(carModel)[0] -= kilometers;
                        System.out.printf("%s mileage decreased by %d kilometers%n", carModel, kilometers);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        cars.entrySet().stream()
                .sorted((f,s) ->{
                    int result = s.getValue()[0] - f.getValue()[0];
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(c-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",c.getKey(),c.getValue()[0],c.getValue()[1]));
    }

}

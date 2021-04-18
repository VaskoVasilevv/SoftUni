package FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedObject {
    static class Cars {
        int distance;
        int fuel;

        public Cars(int distance, int fuel) {
            this.distance = distance;
            this.fuel = fuel;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance += distance;
        }
        public void setDistance1(int distance) {
            this.distance = distance;
        }
        public void decreaseDistance(int distance) {
            this.distance -= distance;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel -= fuel;
        }
        public void addFuel(int fuel) {
            this.fuel += fuel;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Cars> carsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            Cars car = new Cars(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            carsMap.put(input[0], car);

        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String model = tokens[1];
            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (carsMap.get(model).getFuel() < fuel){
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                        carsMap.get(model).setDistance(distance);
                        carsMap.get(model).setFuel(fuel);
                        System.out.printf("%s driven for %s kilometers. %d liters of fuel consumed.%n",model,distance,fuel);

                    }
                    if (carsMap.get(model).getDistance()>= 100000){
                        System.out.println("Time to sell the "+ model+"!");
                        carsMap.remove(model);
                    }
                    break;
                case "Refuel":
                     int amount = Integer.parseInt(tokens[2]);

                    if (carsMap.get(model).getFuel() + amount > 75){
                        amount = 75 - carsMap.get(model).getFuel();
                    }
                    carsMap.get(model).addFuel(amount);
                    System.out.printf("%s refueled with %d liters%n",model,amount);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    carsMap.get(model).decreaseDistance(kilometers);
                    if (carsMap.get(model).getDistance()< 10000){
                        carsMap.get(model).setDistance1(10000);
                        break;
                    }
                    System.out.printf("%s mileage decreased by %d kilometers%n",model,kilometers);
                    break;
            }

            input = scanner.nextLine();
        }
        carsMap.entrySet().stream()
                .sorted((a,b)->{
                    int result = b.getValue().getDistance() - a.getValue().getDistance();
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",c.getKey(),c.getValue().getDistance(),c.getValue().getFuel()));
    }
}

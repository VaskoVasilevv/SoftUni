package Polymorphism.Ex.vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(vehicleData[1]), Double.parseDouble(vehicleData[2]));
        vehicleData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(vehicleData[1]), Double.parseDouble(vehicleData[2]));

        Map<String, Vehicle> vehicle = new HashMap<>();
        vehicle.put("Car", car);
        vehicle.put("Truck", truck);


        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String output = null;
            if (tokens[0].equals("Drive")) {
                output = vehicle.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else {
                vehicle.get(tokens[1]).reFuel(Double.parseDouble(tokens[2]));

            }
            if (output != null){
                System.out.println(output);
            }
        }

        vehicle.forEach((key, value) -> System.out.println(value));
    }
}

package bg.softuni.fundamentals.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06VehicleCatalogueEX {

    static class Vehicle {

        String type;
        String model;
        String color;
        int horsePower;

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1)
                    , getModel(), getColor(), getHorsePower());

        }
    }

    public static double averageHorsepower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0;
        }
        return vehicles.stream().mapToDouble(Vehicle::getHorsePower).sum() / vehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> allVehicles = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] data = line.split(" ");
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));

            allVehicles.add(vehicle);


            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("Close the Catalogue")) {
            String model = line;

            allVehicles.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));


            line = scanner.nextLine();
        }

        List<Vehicle> cars = allVehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> trucks = allVehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHorsepower(trucks));
    }
}

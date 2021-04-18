package Abstraction.Ex.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] startLights = scanner.nextLine().split("\\s+");
        int countUpdates = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String light : startLights) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(light));
            trafficLights.add(trafficLight);

        }
        for (int i = 0; i < countUpdates; i++) {
            for (TrafficLight lights : trafficLights) {
                lights.update();
                System.out.print(lights.getColor()+" ");
            }
            System.out.println();


        }

    }
}

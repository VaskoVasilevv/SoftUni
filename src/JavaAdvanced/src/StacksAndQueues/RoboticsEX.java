package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RoboticsEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());

        String[] names = new String[robots.size()];
        int[] processesTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            names[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processesTime[i] = time;
        }

        String startTime = scanner.nextLine();

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct;
        while (!"End".equals(inputProduct = scanner.nextLine())) {
            productsQueue.offer(inputProduct);
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotsWorkLeft = new int[robots.size()];

        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }
                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }
            if (index != -1) {
                robotsWorkLeft[index] = processesTime[index];
                System.out.println(printRobotData(names[index], product, startTimeInSeconds));
            } else {
                productsQueue.offer(product);
            }
        }
    }

    public static String printRobotData(String robot, String product, int beginTime) {
        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return String.format("%s - %s [%s]", robot, product, time);
    }
}

package AssociativeArrays;

import java.util.*;

public class Live {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> infectedByCity = new TreeMap<>();

        String command = scanner.next();
        while (!command.equals("end")){
            if (command.equals("report")){
                String cityName = scanner.next();
                System.out.println(infectedByCity.get(cityName));
            }else {
                int infected = scanner.nextInt();

                Integer currnetInfected = infectedByCity.get(command);
                if (currnetInfected == null){
                    currnetInfected = 0;
                }
                infectedByCity.put(command, currnetInfected + infected);
            }
            command= scanner.next();
        }
        for (Map.Entry<String, Integer> entry : infectedByCity.entrySet()) {
            System.out.println(entry.getKey()+  "->" +entry.getValue());
        }


    }
}

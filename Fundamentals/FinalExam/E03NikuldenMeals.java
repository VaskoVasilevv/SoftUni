package bg.softuni.fundamentals.FinalExam;

import java.util.*;

public class E03NikuldenMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<String>> likedMeals = new HashMap<>();
        int unlikedMeals = 0;
        while (!line.equals("Stop")){
            String[] split = line.split("-");
            String type = split[0];
            String guestName = split[1];
            String mealName = split[2];

            if (type.equals("Like")){
//              likedMeals.putIfAbsent(guestName,new ArrayList<>());
                List<String> guestMeals = likedMeals.get(guestName);
                if (guestMeals == null){
                    guestMeals = new ArrayList<>();
                }
                if (!guestMeals.contains(mealName)){
                    guestMeals.add(mealName);
                }
                likedMeals.put(guestName,guestMeals);
            }else {
                if (!likedMeals.containsKey(guestName)){
                    System.out.printf("%s is not at the party.%n",guestName);
                }else {
                    List<String> meals = likedMeals.get(guestName);

                    if (!meals.contains(mealName)){
                        System.out.printf("%s doesn't have the %s in his/her collection.%n",guestName,mealName);
                    }else {
                        unlikedMeals ++;
                        System.out.printf("%s doesn't like the %s%n",guestName,mealName);
                        meals.remove(mealName);
                        likedMeals.put(guestName,meals);
                    }
                }
            }

            line = scanner.nextLine();
        }
        likedMeals.entrySet().stream()
                .sorted((a,b)-> {
                    int result = Integer.compare(b.getValue().size(),a.getValue().size());
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(e-> System.out.println(e.getKey() + ": " + String.join(", ",e.getValue())));

        System.out.println("Unliked meals: "+ unlikedMeals);
    }


}

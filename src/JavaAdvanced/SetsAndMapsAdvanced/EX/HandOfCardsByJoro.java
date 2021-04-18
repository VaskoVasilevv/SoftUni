package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.*;

public class HandOfCardsByJoro {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Map<String, Set<String>> playersInfo=new LinkedHashMap<>();
    String input;
        while (!"JOKER".equals(input=scan.nextLine())){
        String[]inputData=input.split(": ");
        String[]cards= inputData[1].split(", ");
        playersInfo.putIfAbsent (inputData[0], new HashSet<>());
        playersInfo.get (inputData[0]).addAll (Arrays.asList (cards.clone ()));
    }
        playersInfo.forEach((key,value)-> System.out.printf("%s: %d%n",key,getSumOfCards(value)));
}

    private static int getSumOfCards(Set<String> value) {
        int sum=0;
        for (String s : value) {
            char type=s.charAt(s.length()-1);
            String power=s.substring(0,s.length()-1);
            int multiplied=0;
            switch (type){
                case'S': multiplied=4; break;
                case'H': multiplied=3; break;
                case'D': multiplied=2; break;
                case'C': multiplied=1; break;
            }
            int powerNumber=0;
            try{
                powerNumber=Integer.parseInt(power);
            }catch (Exception exception){
                switch (power){
                    case "J": powerNumber=11; break;
                    case "Q": powerNumber=12; break;
                    case "K": powerNumber=13; break;
                    case "A": powerNumber=14; break;
                }
            }
            sum+=powerNumber*multiplied;
        }
        return sum;
    }
}

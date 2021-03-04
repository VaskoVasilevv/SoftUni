package Inheritance.Lab.RandomArrayList;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("Pesho");
        randomArrayList.add('a');
        randomArrayList.add(new BigDecimal("1.24"));

        System.out.println(randomArrayList.getRandomElement());
    }
}

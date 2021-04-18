package JavaOOP.Polymorphism.Ex.wildFarm.animals;


import JavaOOP.Polymorphism.Ex.wildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    protected Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public void eat(Food food){

        this.foodEaten += food.getQuantity();
    }

    protected String getType() {
        return type;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, region, %d]"
        ,this.getType()
        ,this.name
        ,format.format(this.weight)
        ,this.foodEaten);
    }
}

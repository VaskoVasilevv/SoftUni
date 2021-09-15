package Exam.Exam.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if (this.data.size()<capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        return this.data.removeIf(e -> e.getManufacturer().equals(manufacturer)&& e.getModel().equals(model));
    }
    public Car getLatestCar(){
        return this.data.stream().max((f,s) -> f.getYear() - s.getYear()).orElse(null);
    }
    public Car getCar(String manufacturer, String model){
        return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer)&& e.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The cars are in a car Exam.Exam.dealership " + name);
        sb.append(":").append(System.lineSeparator());
        this.data.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

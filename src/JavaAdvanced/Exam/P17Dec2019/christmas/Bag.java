package JavaAdvanced.Exam.P17Dec2019.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(getColor()).append(" bag contains:").append(System.lineSeparator());
        this.data.forEach(element->output.append(element).append(System.lineSeparator()));
        return output.toString();
    }

    public Present getPresent(String name){
        return this.data.stream().filter(element->element.getName().equals(name)).findFirst().orElse(null);
    }

    public Present heaviestPresent(){
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public boolean remove(String name){
        return this.data.removeIf(element->element.getName().equals(name));
    }

    public void add(Present present){
        if(this.data.size()<this.capacity){
            this.data.add(present);
        }
    }

    public int count(){
        return this.data.size();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
}

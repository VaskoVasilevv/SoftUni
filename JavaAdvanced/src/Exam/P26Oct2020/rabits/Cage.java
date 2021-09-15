package Exam.P26Oct2020.rabits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Rabbit rabbit){
        if (data.size()<this.capacity){
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }
    public void removeSpecies(String species){
       this.data =  this.data.stream().filter(r -> !r.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public Rabbit sellRabbit(String name){
        this.data.stream().filter(r -> r.getName().equals(name)).findFirst().ifPresent(e ->e.setAvailable(false));
        return this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        this.data.stream().filter(e->e.getSpecies().equals(species)).forEach(v-> v.setAvailable(false));
        return this.data.stream().filter(e->e.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder out = new StringBuilder("Rabbits available at ");
        out.append(this.name).append(":").append(System.lineSeparator());
        this.data.stream().filter(e -> e.isAvailable()).forEach(v->out.append(v).append(System.lineSeparator()));
        return out.toString().trim();
    }
}

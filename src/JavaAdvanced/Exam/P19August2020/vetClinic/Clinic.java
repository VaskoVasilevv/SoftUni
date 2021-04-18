package JavaAdvanced.Exam.P19August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        //  return employees.removeIf(e -> e.getName().equals(name));

        int index = -1;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)){
                index = i;
            }
        }
        if (index!= -1){
            data.remove(index);
            return true;
        }
        return false;
    }
    public Pet getPet (String name, String owner){

        return data.stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).findFirst().orElse(null);

//        Pet pet = null;
//        for (Pet p : data) {
//            if (p == null || (p.getName().equals(name) && p.getOwner().equals(owner))){
//                pet = p;
//            }
//
//        }
//        return pet;

    }
    public Pet getOldestPet(){
        return data.stream().min((p1,p2)->Integer.compare(p2.getAge(),p1.getAge())).orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        data.forEach(e-> sb.append(e.getName()).append(" ").append(e.getOwner()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

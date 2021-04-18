package JavaAdvanced.Exam.P28June2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer,String model){
        //  return employees.removeIf(e -> e.getName().equals(name));
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public Car getLatestCar(){

//        return data.stream().min((p1,p2)->Integer.compare(p2.getAge(),p1.getAge())).orElse(null);

        return data.stream().max((f,s) -> Integer.compare(f.getYear(),s.getYear())).orElse(null);
    }
    public Car getCar(String manufacturer,String model){
       return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The cars are parked in ");
        sb.append(type).append(":").append(System.lineSeparator());
                data.forEach(c ->sb.append(c).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

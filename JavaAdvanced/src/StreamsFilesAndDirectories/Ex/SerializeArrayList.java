package StreamsFilesAndDirectories.Ex;

import java.io.*;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {

        String PATH = "C:\\Users\\Precision\\OneDrive\\Работен плот\\list.ser";

        List<Double> list = List.of(4.5, 3.7, 8.8);

        try (FileOutputStream fos = new FileOutputStream(PATH)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fos = new FileInputStream(PATH)){
            ObjectInputStream oos = new ObjectInputStream(fos);
            List<Double> deserial = (List<Double>) oos.readObject();
            deserial.forEach(System.out::println);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

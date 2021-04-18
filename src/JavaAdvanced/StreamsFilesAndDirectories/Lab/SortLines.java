package JavaAdvanced.StreamsFilesAndDirectories.Lab;


import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input1.txt";


        List<String> lines = Files.readAllLines(Paths.get(path)).stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get(output),lines);


    }
}

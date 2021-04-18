package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        String output = "out.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream(output);

        PrintWriter writer = new PrintWriter(outputStream);

        int singleBye = inputStream.read();
        Set<Character> punctoations = new HashSet<>();
        punctoations.add(',');
        punctoations.add('.');
        punctoations.add('!');
        punctoations.add('?');
        while (singleBye >= 0){

            char symbol = (char) singleBye;

            if (!punctoations.contains(symbol)){
                writer.print(symbol);
            }
            singleBye = inputStream.read();
        }

        writer.close();

        inputStream.close();
    }
}

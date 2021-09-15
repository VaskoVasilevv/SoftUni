package StreamsFilesAndDirectories.Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Encapsulation.Lab.Ex\\Recources\\input.txt"))) {
            String line = reader.readLine();

            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();

            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

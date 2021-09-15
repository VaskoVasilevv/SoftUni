package StreamsFilesAndDirectories.Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class ALLCAPITALS {
    private static final String INPUT_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Encapsulation.Lab.Ex\\input.txt";
    private static final String OUTPUT_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Encapsulation.Lab.Ex\\output.txt";
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

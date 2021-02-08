package StreamsFilesAndDirectories.Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    private static final String INPUT_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Ex\\Recources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Ex\\Recources\\output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            int number = 1;
            while (line != null) {
                String line1 = String.format("%d. %s%n",number,line);
                writer.write(line1);
                number ++;
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

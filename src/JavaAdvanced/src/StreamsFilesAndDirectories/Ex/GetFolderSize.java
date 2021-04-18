package StreamsFilesAndDirectories.Ex;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {

    private static final String DIR_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Encapsulation.Lab.Ex\\Recources\\Exercises Resources";
    private static final String OUTPUT_PATH = "D:\\SoftUniGit\\SoftUni\\src\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Encapsulation.Lab.Ex\\Recources\\result.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: " + size);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

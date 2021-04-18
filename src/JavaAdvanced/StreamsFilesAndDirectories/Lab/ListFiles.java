package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String output = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";

        File file = new File(fileName);

        File[] iinerFiles = file.listFiles();

        for (File iinerFile : iinerFiles) {
            if (!iinerFile.isDirectory()){
                System.out.printf("%s: [%d]%n",iinerFile.getName(),iinerFile.length());
            }
        }


    }
}

package StreamsFilesAndDirectories.Lab;



import java.io.FileInputStream;

import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int singleBye = inputStream.read();

        while (singleBye >= 0){
            System.out.print(Integer.toBinaryString(singleBye)+" ");

            singleBye = inputStream.read();
        }
        inputStream.close();
    }
}

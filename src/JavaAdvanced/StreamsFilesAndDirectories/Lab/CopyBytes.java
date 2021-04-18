package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {


        String path = "input.txt";
        String output = "out.txt";
        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream(output);

        PrintWriter writer = new PrintWriter(outputStream);

        int singleBye = inputStream.read();

        while (singleBye >= 0){

            if (singleBye == 10 || singleBye == 32){
                writer.print((char) singleBye);
            }else {
                writer.print(singleBye);
            }
            singleBye = inputStream.read();
        }

        writer.close();

        inputStream.close();
    }
}

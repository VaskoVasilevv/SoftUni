package StreamsFilesAndDirectories.Ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) {

        String picture = "C:\\Users\\Precision\\OneDrive\\Работен плот\\softuni-2.0.jpg";
        String output = "C:\\Users\\Precision\\OneDrive\\Работен плот\\result.jpg";

        try(FileInputStream fis  = new FileInputStream(picture)){
            FileOutputStream fos = new FileOutputStream(output);

            int oneByte = fis.read();
            while (oneByte != -1){
                fos.write(oneByte);
                oneByte = fis.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

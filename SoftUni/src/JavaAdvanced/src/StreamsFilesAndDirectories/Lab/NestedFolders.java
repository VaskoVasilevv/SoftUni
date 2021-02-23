package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {


        String path = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String output = "C:\\Users\\Precision\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");


    }
}

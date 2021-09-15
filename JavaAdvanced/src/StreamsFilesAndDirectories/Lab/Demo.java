package StreamsFilesAndDirectories.Lab;


import java.io.*;


public class Demo {
    public static void main(String[] args) throws IOException {

//        try {
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\Precision\\OneDrive\\Работен плот\\New Text Document (2).txt");
//            Scanner scanner = new Scanner(inputStream);
//            String str = scanner.nextLine();
//            System.out.println(str);
//        }catch (FileNotFoundException ex){
//            System.out.println(ex.getMessage());
//        }
        String path = "input.txt";
        String output = "out.txt";

//        List<String> lines = new ArrayList<>();
//        List<String> strings = Files.readAllLines(Path.of(path));
//
//        for (int i = 2; i < strings.size(); i += 3) {
//            lines.add(strings.get(i));
//        }
////            Files.write(Path.of(output), Collections.singleton(strings.get(i)), StandardCharsets.UTF_8);
//

        BufferedReader in = new BufferedReader(new FileReader(path));
        BufferedWriter out = new BufferedWriter(new FileWriter(output));

        String line = in.readLine();
        int lineNumber = 1;

        while (line != null) {
            lineNumber++;
            line = in.readLine();
            if (lineNumber % 3 == 0) {
                out.write(line);
                out.newLine();
            }
        }
        out.close();
    }
}

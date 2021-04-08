package ExamPreparation_2.bakery.io;


import ExamPreparation_2.bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}

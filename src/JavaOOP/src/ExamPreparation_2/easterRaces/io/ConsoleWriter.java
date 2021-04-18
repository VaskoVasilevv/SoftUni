package ExamPreparation_2.easterRaces.io;
//created by J.M.

import ExamPreparation_2.easterRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}

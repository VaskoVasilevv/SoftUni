package ExamPreparation_1.viceCity;
//created by J.M.

import ExamPreparation_1.viceCity.core.ControllerImpl;
import ExamPreparation_1.viceCity.core.EngineImpl;
import ExamPreparation_1.viceCity.core.interfaces.Controller;
import ExamPreparation_1.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}

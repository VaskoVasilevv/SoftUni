package EXAMS.spaceStation;

import EXAMS.spaceStation.core.Controller;
import EXAMS.spaceStation.core.ControllerImpl;
import EXAMS.spaceStation.core.Engine;
import EXAMS.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}

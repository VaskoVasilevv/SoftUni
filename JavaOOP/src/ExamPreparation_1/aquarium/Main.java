package ExamPreparation_1.aquarium;

import ExamPreparation_1.aquarium.core.Engine;
import ExamPreparation_1.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}

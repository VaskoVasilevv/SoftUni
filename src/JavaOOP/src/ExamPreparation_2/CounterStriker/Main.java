package ExamPreparation_2.CounterStriker;

import ExamPreparation_2.CounterStriker.core.EngineImpl;
import ExamPreparation_2.CounterStriker.core.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}

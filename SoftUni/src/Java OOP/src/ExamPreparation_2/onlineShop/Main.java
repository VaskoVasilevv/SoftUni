package ExamPreparation_2.onlineShop;

import ExamPreparation_2.onlineShop.core.EngineImpl;
import ExamPreparation_2.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}

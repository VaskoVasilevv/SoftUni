package ExamPreparation_2.easterRaces;
//created by J.M.

import ExamPreparation_2.easterRaces.core.ControllerImpl;
import ExamPreparation_2.easterRaces.core.EngineImpl;
import ExamPreparation_2.easterRaces.core.interfaces.Controller;
import ExamPreparation_2.easterRaces.entities.interfaces.Car;
import ExamPreparation_2.easterRaces.entities.interfaces.Driver;
import ExamPreparation_2.easterRaces.entities.interfaces.Race;
import ExamPreparation_2.easterRaces.io.ConsoleReader;
import ExamPreparation_2.easterRaces.io.ConsoleWriter;
import ExamPreparation_2.easterRaces.repositories.CarRepository;
import ExamPreparation_2.easterRaces.repositories.DriverRepository;
import ExamPreparation_2.easterRaces.repositories.RaceRepository;
import ExamPreparation_2.easterRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> motorcycleRepository = new CarRepository<>();
        Repository<Race> raceRepository = new RaceRepository<>();
        Repository<Driver> riderRepository = new DriverRepository<>();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}

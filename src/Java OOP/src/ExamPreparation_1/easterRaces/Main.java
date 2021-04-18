package ExamPreparation_1.easterRaces;

import ExamPreparation_1.easterRaces.core.ControllerImpl;
import ExamPreparation_1.easterRaces.core.EngineImpl;
import ExamPreparation_1.easterRaces.core.interfaces.Controller;
import ExamPreparation_1.easterRaces.entities.interfaces.Car;
import ExamPreparation_1.easterRaces.entities.interfaces.Driver;
import ExamPreparation_1.easterRaces.entities.interfaces.Race;
import ExamPreparation_1.easterRaces.io.ConsoleReader;
import ExamPreparation_1.easterRaces.io.ConsoleWriter;
import ExamPreparation_1.easterRaces.repositories.CarRepository;
import ExamPreparation_1.easterRaces.repositories.DriverRepository;
import ExamPreparation_1.easterRaces.repositories.RaceRepository;
import ExamPreparation_1.easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Car> motorcycleRepository =  new CarRepository<Car>();
        Repository<Race> raceRepository = new RaceRepository<>();
        Repository<Driver> riderRepository =  new DriverRepository<>();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}

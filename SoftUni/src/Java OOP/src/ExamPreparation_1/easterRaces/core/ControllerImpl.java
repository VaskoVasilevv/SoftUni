package ExamPreparation_1.easterRaces.core;

import ExamPreparation_1.easterRaces.core.interfaces.Controller;
import ExamPreparation_1.easterRaces.entities.cars.MuscleCar;
import ExamPreparation_1.easterRaces.entities.cars.SportsCar;
import ExamPreparation_1.easterRaces.entities.drivers.DriverImpl;
import ExamPreparation_1.easterRaces.entities.interfaces.Car;
import ExamPreparation_1.easterRaces.entities.interfaces.Driver;
import ExamPreparation_1.easterRaces.entities.interfaces.Race;
import ExamPreparation_1.easterRaces.entities.racers.RaceImpl;
import ExamPreparation_1.easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static ExamPreparation_1.easterRaces.common.ExceptionMessages.*;
import static ExamPreparation_1.easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository,
                          Repository<Car> carRepository,
                          Repository<Race> raceRepository) {

        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        Driver newDriver = new DriverImpl(driverName);

        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }
        driverRepository.add(newDriver);

        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;

        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        } else {
            carRepository.add(car);
        }
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);

    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null) {

            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (carRepository.getByName(carModel) == null) {

            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));

        } else if (raceRepository.getByName(raceName) == null) {

            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Race race = raceRepository.getByName(raceName);
        if (race.getDrivers().size()<3){
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        List<Driver> listOfWinners = race.getDrivers().stream()
                .sorted((f,s)-> Double.compare(s.getCar().calculateRacePoints(race.getLaps()),
                        f.getCar().calculateRacePoints(race.getLaps()))).
                        limit(3).collect(Collectors.toList());
        raceRepository.remove(race);
        StringBuilder sb = new StringBuilder(String.format(DRIVER_FIRST_POSITION, listOfWinners.get(0).getName(), race.getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, listOfWinners.get(1).getName(), race.getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, listOfWinners.get(2).getName(), race.getName()));
        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (raceRepository.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}

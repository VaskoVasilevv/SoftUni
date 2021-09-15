package ExamPreparation_1.easterRaces.entities.drivers;

import ExamPreparation_1.easterRaces.common.ExceptionMessages;
import ExamPreparation_1.easterRaces.entities.interfaces.Car;
import ExamPreparation_1.easterRaces.entities.interfaces.Driver;

import static ExamPreparation_1.easterRaces.common.ExceptionMessages.CAR_INVALID;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        this.setCanParticipate(canParticipate);
    }

    public void setCanParticipate(boolean canParticipate) {
         if (this.car != null){
             this.canParticipate = canParticipate;
         }
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME,name,5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.car != null;
    }
}

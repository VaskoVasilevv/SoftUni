package ExamPreparation_2.easterRaces.entities.interfaces;
//created by J.M.

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}

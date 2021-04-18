package ExamPreparation_1.easterRaces.entities.interfaces;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}

package DefendingClasses.Ex.Google;

public class Car {
    private String name;
    private String carModel;
    private String carSpeed;

    public Car(String name, String carModel, String carSpeed) {
        this.name = name;
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {

        return String.format("%s %s",carModel, carSpeed);
    }
}

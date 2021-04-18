package JavaAdvanced.DefendingClasses.Ex.RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int power) {
        this.engineSpeed = engineSpeed;
        this.enginePower = power;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }
}

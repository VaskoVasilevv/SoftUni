package DefendingClasses.Ex.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tier[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tier[] getTiers() {
        return tiers;
    }

    public void setTiers(Tier[] tiers) {
        this.tiers = tiers;
    }
    public boolean hasTiereLessPressure(){
        for (Tier tier : tiers) {
            if (tier.getPressure()<1){
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return this.model;
    }
}

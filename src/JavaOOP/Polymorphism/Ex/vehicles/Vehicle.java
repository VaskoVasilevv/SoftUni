package JavaOOP.Polymorphism.Ex.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private boolean airConditionIsOn;
    private double fuelConsumption;
    private double additionalConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption,double additionalConsumption,double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setAirConditionIsOn();
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption( fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            System.out.println("Fuel must be a positive number");
        }else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    protected void setFuelConsumption(double fuelConsumption) {
        if (airConditionIsOn) {
            this.fuelConsumption = fuelConsumption + additionalConsumption;
        }else {
            this.fuelConsumption = fuelConsumption;
        }
    }

    private   void setAirConditionIsOn(){
        this.airConditionIsOn = true;
    }



    public String drive(double distance) {
        String output = null;
        double fuelNeeded = distance * this.fuelConsumption;
        DecimalFormat format = new DecimalFormat("#.##");
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            output = String.format("%s travelled %s km"
                    , this.getClass().getSimpleName()
                    , format.format(distance));
        }else {
            output = String.format("%s needs refueling",this.getClass().getSimpleName());
        }

        return output;
    }

    public void reFuel(double fuel){
        if (this.fuelQuantity + fuel > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }else if (fuel <= 0){
            System.out.println("Fuel must be a positive number");
        }
        else {
            this.fuelQuantity += fuel;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}

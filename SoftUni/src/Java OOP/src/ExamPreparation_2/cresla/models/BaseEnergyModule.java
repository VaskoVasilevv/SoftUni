package ExamPreparation_2.cresla.models;

import ExamPreparation_2.cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {
    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override

    public int getEnergyOutput() {

        return this.energyOutput;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nEnergy Output: %d",this.getEnergyOutput());
    }
}


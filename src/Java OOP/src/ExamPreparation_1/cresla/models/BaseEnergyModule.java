package ExamPreparation_1.cresla.models;

import ExamPreparation_1.cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {

    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput = energyOutput;
    }

    @Override
    public String toString() {
        //        {additionalParam}: {additionalParamValue}
        return super.toString() + String.format("\nEnergy Output: %d", this.getEnergyOutput());
    }
}

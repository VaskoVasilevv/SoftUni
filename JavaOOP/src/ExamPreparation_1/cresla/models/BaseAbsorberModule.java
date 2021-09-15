package ExamPreparation_1.cresla.models;

import ExamPreparation_1.cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorberModule extends BaseModule implements AbsorbingModule {

    private int heatAbsorbing;

    protected BaseAbsorberModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public String toString() {
        //        {additionalParam}: {additionalParamValue}
        return super.toString()+String.format("\nHeat Absorbing: %d",this.getHeatAbsorbing());
    }
}

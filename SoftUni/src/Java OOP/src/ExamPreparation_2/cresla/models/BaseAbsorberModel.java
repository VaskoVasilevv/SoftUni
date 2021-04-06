package ExamPreparation_2.cresla.models;

import ExamPreparation_2.cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorberModel extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;
    protected BaseAbsorberModel(int id,int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {

        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nHeat Absorbing: %d",this.getHeatAbsorbing());
    }
}

package ExamPreparation_2.cresla.interfaces;

public interface Container {

    long getTotalEnergyOutput();

    long getTotalHeatAbsorbing();

    void addEnergyModule(EnergyModule energyModule);

    void addAbsorbingModule(AbsorbingModule absorbingModule);

    int getModuleByInputCount();
}

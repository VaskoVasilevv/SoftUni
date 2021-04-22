package ReflectionAndAnnotations.Ex.barracksWars.core.commands;

import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Inject;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.UnitFactory;

public class Add extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory factory;

    public Add(String[] data) {
        super(data);

    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.factory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return  unitType + " added!";
    }
}

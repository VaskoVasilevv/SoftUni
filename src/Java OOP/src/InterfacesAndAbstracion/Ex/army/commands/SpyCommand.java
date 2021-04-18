package InterfacesAndAbstracion.Ex.army.commands;

import InterfacesAndAbstracion.Ex.army.Interfaces.Soldier;
import InterfacesAndAbstracion.Ex.army.factories.SoldierFactory;

import java.util.List;

public class SpyCommand extends BaseCommand{

    public SpyCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceSpy(args));
    }
}

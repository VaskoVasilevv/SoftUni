package InterfacesAndAbstracion.Ex.army.commands;

import InterfacesAndAbstracion.Ex.army.Interfaces.Soldier;
import InterfacesAndAbstracion.Ex.army.commands.interfaces.Command;
import java.util.List;


public abstract class BaseCommand implements Command {
    private List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers){
        this.soldiers = soldiers;

    }
    public void add(Soldier soldier){
        this.soldiers.add(soldier);
    }
    protected List<Soldier> getSoldiers(){
        return this.soldiers;
    }
}

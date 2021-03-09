package InterfacesAndAbstracion.Ex.army.Interfaces;

import InterfacesAndAbstracion.Ex.army.Helper.Interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}

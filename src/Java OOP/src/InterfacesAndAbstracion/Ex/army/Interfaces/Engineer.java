package InterfacesAndAbstracion.Ex.army.Interfaces;

import InterfacesAndAbstracion.Ex.army.Helper.Interfaces.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}

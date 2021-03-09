package InterfacesAndAbstracion.Ex.army.Helper.Interfaces;

import InterfacesAndAbstracion.Ex.army.enums.State;

public interface Mission {

    void completeMission();
    String getCodeName();
    State getState();
}

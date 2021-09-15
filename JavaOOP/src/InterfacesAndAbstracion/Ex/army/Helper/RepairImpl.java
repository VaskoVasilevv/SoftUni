package InterfacesAndAbstracion.Ex.army.Helper;

import InterfacesAndAbstracion.Ex.army.Helper.Interfaces.Repair;

public class RepairImpl implements Repair {
    private String name;
    private int hoursWork;

    public RepairImpl(String name, int hoursWork) {
        this.name = name;
        this.hoursWork = hoursWork;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHoursWorked() {

        return this.hoursWork;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.getName(),this.getHoursWorked());
    }
}

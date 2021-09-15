package InterfacesAndAbstracion.Ex.army;


import InterfacesAndAbstracion.Ex.army.Interfaces.Spy;

public class SpyImpl extends SoliderImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName,String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }
    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCode Number: " + getCodeNumber();
    }


}

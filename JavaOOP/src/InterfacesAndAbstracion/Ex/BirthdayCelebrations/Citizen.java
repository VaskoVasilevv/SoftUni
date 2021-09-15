package InterfacesAndAbstracion.Ex.BirthdayCelebrations;

public class Citizen implements Identifiable{
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
}

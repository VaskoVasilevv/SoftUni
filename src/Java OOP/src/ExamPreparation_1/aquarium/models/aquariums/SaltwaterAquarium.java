package ExamPreparation_1.aquarium.models.aquariums;

public class SaltwaterAquarium extends BaseAquarium {

    private static final int CAPACITY_AQUARIUM = 25;
    public static final String AQUARIUM_TYPE = "SaltwaterAquarium";

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY_AQUARIUM);
    }


    @Override
    public String getInfo() {
        return String.format("%s (%s):", super.getName(), AQUARIUM_TYPE) +
                System.lineSeparator() +
                super.getInfo();
    }
}

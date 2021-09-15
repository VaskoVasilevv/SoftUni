package ExamPreparation_1.aquarium.models.fish;

public class FreshwaterFish extends BaseFish {

    private static final int INITIAL_SIZE = 3;
    private static final int INCREASE_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        int size = super.getSize();
        size += INCREASE_SIZE;
        super.setSize(size);
    }

}

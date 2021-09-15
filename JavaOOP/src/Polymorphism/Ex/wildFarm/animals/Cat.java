package Polymorphism.Ex.wildFarm.animals;

public class Cat extends Felime{
    private String bread;
    public Cat(String name, String type, double weight, String livingRegion,String breed) {
        super(name, type, weight, livingRegion);
        this.bread = breed;
    }

    @Override
    public void makeSound() {

        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String baseToStr = super.toString();
        int index = baseToStr.indexOf(",");

        StringBuilder builder = new StringBuilder(baseToStr);

        builder.insert(index + 2, this.bread+ ", ");

        return builder.toString();
    }
}

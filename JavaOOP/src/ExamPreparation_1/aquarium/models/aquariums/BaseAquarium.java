package ExamPreparation_1.aquarium.models.aquariums;

import ExamPreparation_1.aquarium.common.ConstantMessages;
import ExamPreparation_1.aquarium.common.ExceptionMessages;
import ExamPreparation_1.aquarium.models.decorations.Decoration;
import ExamPreparation_1.aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }


    @Override
    public int calculateComfort() {
        return this.getDecorations().stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.getFish().remove(fish);

    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.getDecorations().add(decoration);
    }

    @Override
    public void feed() {
        this.getFish().forEach(Fish::eat);
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (this.getFish().isEmpty()) {
            sb.append("none");
        } else {
            sb.append("Fish: ");
            List<String> collect = this.getFish().stream().map(Fish::getName).collect(Collectors.toList());
            sb.append(String.join(" ", collect));

            sb
                    .append(System.lineSeparator())
                    .append("Decorations: ").append(this.getDecorations().size())
                    .append(System.lineSeparator())
                    .append("Comfort: ")
                    .append(this.calculateComfort());
        }
        return sb.toString();
    }
}
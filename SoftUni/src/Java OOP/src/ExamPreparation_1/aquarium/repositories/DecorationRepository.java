package ExamPreparation_1.aquarium.repositories;

import ExamPreparation_1.aquarium.models.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;
    //(unmodifiable) защо?

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return this.decorations.remove(decoration);//TODO
    }

    @Override
    public Decoration findByType(String type) {
        return this.decorations
                .stream()
                .filter(t -> t.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}

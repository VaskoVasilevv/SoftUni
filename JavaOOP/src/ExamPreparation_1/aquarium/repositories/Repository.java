package ExamPreparation_1.aquarium.repositories;

import ExamPreparation_1.aquarium.models.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}

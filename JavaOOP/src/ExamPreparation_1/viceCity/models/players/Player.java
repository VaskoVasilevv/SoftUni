package ExamPreparation_1.viceCity.models.players;
//created by J.M.

import ExamPreparation_1.viceCity.models.guns.Gun;
import ExamPreparation_1.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}

package ExamPreparation_2.CounterStriker.models.players;

import ExamPreparation_2.CounterStriker.models.guns.Gun;

public interface Player {
    String getUsername();

    int getHealth();

    int getArmor();

    Gun getGun();

    boolean isAlive();

    void takeDamage(int points);
}

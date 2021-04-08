package ExamPreparation_2.CounterStriker.models.players;

import ExamPreparation_2.CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl {
    public CounterTerrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}

package ExamPreparation_2.CounterStriker.repositories;

import ExamPreparation_2.CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static ExamPreparation_2.CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository<Player>{
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Player model) {
        if (model == null){
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
    }

    @Override
    public boolean remove(Player model) {
        String name = model.getUsername();

        return this.models.removeIf(player -> player.getUsername().equals(name));

    }

    @Override
    public Player findByName(String name) {
        this.models.stream().filter(p -> p.getUsername().equals(name)).findFirst().orElse(null);
        return null;
    }
}

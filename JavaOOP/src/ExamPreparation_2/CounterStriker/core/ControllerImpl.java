package ExamPreparation_2.CounterStriker.core;

import ExamPreparation_2.CounterStriker.models.field.Field;
import ExamPreparation_2.CounterStriker.models.field.FieldImpl;
import ExamPreparation_2.CounterStriker.models.guns.Gun;
import ExamPreparation_2.CounterStriker.models.guns.Pistol;
import ExamPreparation_2.CounterStriker.models.guns.Rifle;
import ExamPreparation_2.CounterStriker.models.players.CounterTerrorist;
import ExamPreparation_2.CounterStriker.models.players.Player;
import ExamPreparation_2.CounterStriker.models.players.Terrorist;
import ExamPreparation_2.CounterStriker.repositories.GunRepository;
import ExamPreparation_2.CounterStriker.repositories.PlayerRepository;
import ExamPreparation_2.CounterStriker.repositories.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static ExamPreparation_2.CounterStriker.common.ExceptionMessages.*;
import static ExamPreparation_2.CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static ExamPreparation_2.CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller{
    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun = null;
        switch (type){
            case "Pistol":
                gun = new Pistol(name,bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name,bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        guns.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN,name);

    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {

        if (this.guns.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Gun gun = this.guns.findByName(gunName);
        Player player = null;
        switch (type){
            case "Terrorist":
                player = new Terrorist(username,health,armor,gun);
            case "CounterTerrorist":
                player = new CounterTerrorist(username,health,armor,gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.players.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER,player.getUsername());
    }

    @Override
    public String startGame() {
        Collection<Player> alivePlayers = players.getModels()
                .stream()
                .filter(p -> p.isAlive())
                .collect(Collectors.toList());
        return this.field.start(alivePlayers);
    }

    @Override
    public String report() {
//        return this.players.getModels().stream()
//                .sorted(Comparator.comparing(Player::getUsername))
//                .sorted(Comparator.comparingInt(Player::getHealth).reversed())
//                .sorted(Comparator.comparing(f -> f.getClass().getSimpleName()))
//                .map(Object::toString)
//                .collect(Collectors.joining(System.lineSeparator()));
        StringBuilder sb = new StringBuilder();
        for (Player player : players.getModels()) {
            Comparator.comparing(Player::getUsername);
            sb.append(player.getClass().getSimpleName()).append(": ").append(player.getUsername());
        }


        return sb.toString().trim();
    }
}

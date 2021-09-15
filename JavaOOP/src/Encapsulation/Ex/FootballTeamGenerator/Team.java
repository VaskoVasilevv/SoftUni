package Encapsulation.Ex.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should be empty.");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        players.removeIf(n -> n.getName().equals(name));
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkill)
                .sum() / this.players.size();
    }



    public boolean hasPlayer(String name){
        boolean result = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)){
                result =true;
                break;
            }
        }
        return result;
    }
}

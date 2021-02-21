package Exam.P22Feb2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

//    public void promotePlayer(String name) {
//        this.roster.stream().filter(player -> player.getName().equals(name))
//                .findFirst().ifPresent(player -> player.setRank("Member"));
//    }
//
//    public void demotePlayer(String name) {
//        this.roster.stream().filter(player -> player.getName().equals(name))
//                .findFirst().ifPresent(player -> player.setRank("Trial"));
//    }
public void promotePlayer(String name){
    for (Player player : this.roster) {
        if (player.getName ().equals (name)&&!player.getRank ().equals ("Member")){
            player.setRank ("Member");break;
        }
    }

}
    public void demotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName ().equals (name)&&!player.getRank ().equals ("Trial")){
                player.setRank ("Trial");break;
            }
        }
    }

//    public Player[] kickPlayersByClass(String clazz) {
//        Player[] result = roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
//        setRoster(roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList()));
//        return result;
//    }
public Player[] kickPlayersByClass(String clazz){
    List<Player> arr = new ArrayList<> ();
    for (Player player : this.roster) {
        if (player.getClazz ().equals (clazz)){
            arr.add (player);
        }
    }
    this.roster.removeIf (player -> player.getClazz ().equals (clazz));
    Player[] array = arr.toArray(new Player[0]);
    return array;
}

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Players in the Exam.P22Feb2020.guild: ");
        output.append(getName()).append(":").append(System.lineSeparator());
        getRoster().forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}

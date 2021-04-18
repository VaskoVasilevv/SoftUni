package JavaAdvanced.DefendingClasses.Ex.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    int badges;
    List<Pokemon> pokemonList;

    public
    Trainer (String trainerName) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public
    void setPokemonList (List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public
    List<Pokemon> getPokemonList () {
        return pokemonList;
    }

    public
    void addBadge (int badges) {

        this.badges += 1;
    }

    public
    String getTrainerName () {
        return trainerName;
    }

    private
    void deletePokemon (String pokemonName) {
    }
}

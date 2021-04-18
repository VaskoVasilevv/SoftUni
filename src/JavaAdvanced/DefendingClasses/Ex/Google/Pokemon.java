package JavaAdvanced.DefendingClasses.Ex.Google;

public class Pokemon {
    private String name;
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String name, String pokemonName, String pokemonType) {
        this.name = name;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n",pokemonName, pokemonType);
    }

}

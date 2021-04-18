package DefendingClasses.Ex.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private Car car;

    private String name;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;

    public Person() {
       this.pokemons = new ArrayList<>();
       this.parents = new ArrayList<>();
       this.children = new ArrayList<>();
    }

    public void addPokemon (Pokemon pokemon){
        this.pokemons.add(pokemon);
    }
    public void addParents (Parents parents){
        this.parents.add(parents);
    }
    public  void addChildren(Children children){
        this.children.add(children);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.toString()).append(System.lineSeparator());
        }


        sb.append("Pokemon:").append(System.lineSeparator());
        if(pokemons != null) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }

        sb.append("Parents:").append(System.lineSeparator());
        if(parents != null) {
            for (Parents parent : parents) {
                sb.append(parent);
            }
        }

        sb.append("Children:").append(System.lineSeparator());
        if(children != null) {
            for (Children child : children) {
                sb.append(child);
            }
        }

        return sb.toString();
    }

}

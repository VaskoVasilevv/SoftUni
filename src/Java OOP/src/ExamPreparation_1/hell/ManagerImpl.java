package ExamPreparation_1.hell;

import ExamPreparation_1.hell.entities.heroes.Assassin;
import ExamPreparation_1.hell.entities.heroes.Barbarian;
import ExamPreparation_1.hell.entities.heroes.HeroComparator;
import ExamPreparation_1.hell.entities.heroes.Wizard;
import ExamPreparation_1.hell.entities.items.CommonItem;
import ExamPreparation_1.hell.entities.items.RecipeItem;
import ExamPreparation_1.hell.interfaces.Hero;
import ExamPreparation_1.hell.interfaces.Item;
import ExamPreparation_1.hell.interfaces.Manager;
import ExamPreparation_1.hell.interfaces.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private Map<String, Hero> localHeroes;

    public ManagerImpl() {
        this.localHeroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        String type = arguments.get(1);
        String name = arguments.get(0);
        Hero result = null;


        switch (type) {
            case "Barbarian":
                result = new Barbarian(name);
                break;
            case "Assassin":
                result = new Assassin(name);
                break;
            case "Wizard":
                result = new Wizard(name);
                break;
        }

        localHeroes.put(name, result);

        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String addItem(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointBonusBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));


        Item common = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointBonusBonus, damageBonus);
        Hero current = this.localHeroes.get(heroName);
        current.addItem(common);

        return String.format("Added item - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointBonusBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));
        List<String> requiredItems = arguments
                .stream()
                .skip(8)
                .collect(Collectors.toList());

        Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointBonusBonus, damageBonus, requiredItems);
        Hero current = this.localHeroes.get(heroName);
        current.addRecipe(recipe);

        return String.format("Added recipe - %s to Hero - %s", itemName, heroName);

    }

    @Override
    public String inspect(List<String> arguments) {
        Hero hero = this.localHeroes.get(arguments.get(1));

        return hero.toString();
    }

    @Override
    public String quit() {
        HeroComparator heroComparator = new HeroComparator();
        List<Hero> ordered = this.localHeroes.values()
                .stream()
                .sorted(heroComparator)
                .collect(Collectors.toList());
        int index = 1;
        StringBuilder builder = new StringBuilder();
        for (Hero hero : ordered) {
            builder.append(index)
                    .append(". ")
                    .append(hero.toString())
                    .append("\n");
            index++;
        }

        return builder.toString();
    }
}

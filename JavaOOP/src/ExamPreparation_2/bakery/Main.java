package ExamPreparation_2.bakery;
//created by J.M.

import ExamPreparation_2.bakery.core.ControllerImpl;
import ExamPreparation_2.bakery.core.EngineImpl;
import ExamPreparation_2.bakery.core.interfaces.Controller;
import ExamPreparation_2.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation_2.bakery.entities.drinks.interfaces.Drink;
import ExamPreparation_2.bakery.entities.tables.interfaces.Table;

import ExamPreparation_2.bakery.io.ConsoleReader;
import ExamPreparation_2.bakery.io.ConsoleWriter;
import ExamPreparation_2.bakery.repositories.interfaces.*;
import ExamPreparation_2.bakery.repositories.DrinkRepositoryImpl;
import ExamPreparation_2.bakery.repositories.FoodRepositoryImpl;
import ExamPreparation_2.bakery.repositories.TableRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}

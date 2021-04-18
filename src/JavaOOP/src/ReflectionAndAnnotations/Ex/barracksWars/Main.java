package ReflectionAndAnnotations.Ex.barracksWars;

import ReflectionAndAnnotations.Ex.barracksWars.core.CommandInterpreterImpl;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations.Ex.barracksWars.core.Engine;
import ReflectionAndAnnotations.Ex.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations.Ex.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}

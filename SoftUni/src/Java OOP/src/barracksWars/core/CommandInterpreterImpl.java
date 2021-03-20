package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        String command = getCorrectClassName(data[0]);
        Executable executable = null;

        try {
            Class clazz = Class.forName(COMMAND_PACKAGE + command);
            Constructor declaredConstructor = clazz.getDeclaredConstructor(String[].class);
            executable = (Executable) declaredConstructor.newInstance(new Object[]{data});

            populateDependencies(executable);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void populateDependencies(Executable executable) {

        Field[] exeFields = executable.getClass().getDeclaredFields();
        Field[] currentClazzFields = this.getClass().getDeclaredFields();

        for (Field requiredField : exeFields) {
            Inject annotation = null;
            try {
                annotation = requiredField.getAnnotation(Inject.class);
            }catch (ClassCastException ex){
                continue;
            }

            for (Field currentField : currentClazzFields) {
                if (currentField.getType().equals(requiredField.getType())) {
                    requiredField.setAccessible(true);
                    try {
                        requiredField.set(executable, currentField.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    private String getCorrectClassName(String name) {
        StringBuilder builder = new StringBuilder();

        builder.append(Character.toUpperCase(name.charAt(0)));
        builder.append(name.substring(1));

        return builder.toString();
    }
}

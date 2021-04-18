package ReflectionAndAnnotations.Lab.firstProblem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {


        Class<Reflection> clazz = Reflection.class;
        System.out.println("class " + clazz.getName());

        Class<? super Reflection> baseClazz = clazz.getSuperclass();
        System.out.println("class " +baseClazz.getName());

        Arrays.stream(clazz.getInterfaces()).forEach(i -> System.out.println("interface " +i.getName()));

        try {
            Constructor<Reflection> ctor = clazz.getDeclaredConstructor(
                    String.class,String.class,String.class
            );
            Reflection reflection = ctor.newInstance();
            System.out.println(reflection.toString());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ignored) {
            ignored.printStackTrace();
        }
    }

    public static String getClassName() {
        return "java.lang";
    }
}

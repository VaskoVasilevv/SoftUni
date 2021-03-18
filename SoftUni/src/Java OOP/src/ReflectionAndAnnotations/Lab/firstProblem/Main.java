package ReflectionAndAnnotations.Lab.firstProblem;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static class MethodCompertator implements Comparator<Method>{

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        try {
//            Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
//            Reflection reflection = ctor.newInstance();

            Method[] declaredMethods = clazz.getDeclaredMethods();
            Set <Method> getters = new TreeSet<>(new MethodCompertator());
            Set <Method> setters = new TreeSet<>(new MethodCompertator());

            for (Method m : declaredMethods) {
                if (m.getName().contains("get")){
                    getters.add(m);
                }else if (m.getName().equals("set")){
                    setters.add(m);
                }
            }

            for (Method getter : getters) {
                System.out.println(getter.getName()+ " will return "+getter.getReturnType());
            }
            for (Method setter : setters) {
                System.out.println(setter.getName()+ " and will set field of "+setter.getParameterTypes()[0]);
            }
//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

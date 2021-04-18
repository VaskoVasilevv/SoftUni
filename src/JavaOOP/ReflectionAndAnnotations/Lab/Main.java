package JavaOOP.ReflectionAndAnnotations.Lab;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Class<MyMethods> clazz = MyMethods.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Author subject = method.getAnnotation(Author.class);

            if (subject != null){

            }
        }




    }
}

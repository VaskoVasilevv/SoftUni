package Generics.Lab.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("Unchecked")
    public static <T> T[] create(int length, T item){
        T[] arr =(T[]) Array.newInstance(item.getClass(),length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;

        }

        return arr;
    }

    @SuppressWarnings("Unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T item){
        T[] arr =(T[] ) Array.newInstance(clazz,length);

        Arrays.fill(arr, item);

        return arr;
    }
}

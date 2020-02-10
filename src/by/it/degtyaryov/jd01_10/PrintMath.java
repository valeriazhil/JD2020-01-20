package by.it.degtyaryov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {

    public static void main(String[] args) {
        Class<Math> math = Math.class;
        for (Field field : math.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.println(field);
            }
        }
        for (Method method : math.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }
}

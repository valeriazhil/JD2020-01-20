package by.it.makarenko.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            if((method.getModifiers()& Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method);
        }
    }
}

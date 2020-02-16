package by.it.demchik.jd01_10;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method.toString().replace("java.lang.Math.", ""));
        }
        Field[] priv=structMath.getDeclaredFields();
        for (Field field:priv) {
            if((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            System.out.println(field.toString().replace("java.lang.Math.", ""));
        }

        }
}


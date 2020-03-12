package by.it.makarenko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {


    public static void main(String[] args) {
        Class<Math> structurMath = Math.class;
        Method[] methods = structurMath.getDeclaredMethods();
        Field[] fields = structurMath.getDeclaredFields();
        for (Method method : methods){
            if ((method.getModifiers() & Modifier.PUBLIC )==Modifier.PUBLIC){
                System.out.println(method.toString().replaceAll("java.lang.Math.", ""));
            }
        }
        for (Field field: fields){
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                System.out.println(field.getGenericType() + " " + field.getName());
            }
        }
    }
}

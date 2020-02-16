package by.it.anackij.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder stringBuilder = new StringBuilder();
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                stringBuilder.append("public ");
            }
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                stringBuilder.append("static ");
            }

            stringBuilder.append(method.getGenericReturnType()).append(" ");
            stringBuilder.append(method.getName());
            stringBuilder.append(Arrays.toString(method.getParameterTypes()));
            String output = stringBuilder.toString().replaceAll("]",")").replace("[","(");
            System.out.println(output);
        }
    }
}
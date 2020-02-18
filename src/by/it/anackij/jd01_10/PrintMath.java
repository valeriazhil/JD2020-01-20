package by.it.anackij.jd01_10;

import java.lang.reflect.Field;
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

                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    stringBuilder.append("static ");
                }

                stringBuilder.append(method.getGenericReturnType()).append(" ");
                stringBuilder.append(method.getName());
                stringBuilder.append(Arrays.toString(method.getParameterTypes()));
                String output = stringBuilder.toString().replaceAll("]", ")")
                        .replace("[", "(")
                        .replaceAll(", ", ",");
                System.out.println(output);
            }
        }
        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers()& Modifier.PUBLIC)==Modifier.PUBLIC){
                StringBuilder stringBuilder = new StringBuilder();
                if ((field.getModifiers() & Modifier.STATIC)==Modifier.STATIC){
                    stringBuilder.append(field.getGenericType()).append(" ").append(field.getName());
                }
                System.out.println(stringBuilder);
            }
        }
    }
}
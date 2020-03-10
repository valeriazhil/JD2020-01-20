package by.it.bunkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class PrintString {
    public static void main(String[] args) {
        Class<String> string = String.class;
        StringBuilder text = new StringBuilder();

        for (Method method : string.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) {
                text.append(method.getName())
                        .append("\n");
            }
        }
        System.out.println(text);
    }

}

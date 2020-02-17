package by.it.dolgiy.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if ((declaredMethod.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(declaredMethod.getName());
        }
    }
}

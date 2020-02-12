package by.it.akhmelev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();

            if (Modifier.isPublic(method.getModifiers())) out.append("public ");
            if (Modifier.isStatic(method.getModifiers())) out.append("static ");
            out.append(method.getReturnType().getSimpleName()).append(' ');
            out.append(method.getName()).append('(');
            //дальше сами....
            System.out.println(out);
        }
    }
}

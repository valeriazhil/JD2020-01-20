package by.it.degtyaryov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {

    public static void main(String[] args) {
        String sb = getPublicFieldMathClass() +
                getPublicMethodsMathClass();
        System.out.println(sb);
    }

    private static String getPublicFieldMathClass() {
        Class<Math> math = Math.class;
        StringBuilder text = new StringBuilder();

        for (Field field : math.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                text.append("public ");
                if (Modifier.isStatic(field.getModifiers())) {
                    text.append("static ");
                }
                text.append(field.getType())
                        .append(' ')
                        .append(field.getName())
                        .append("\n");
            }
        }

        return text.toString();
    }

    private static String getPublicMethodsMathClass() {
        Class<Math> math = Math.class;
        StringBuilder text = new StringBuilder();

        for (Method method : math.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                text.append("public ");
                if (Modifier.isStatic(method.getModifiers())) {
                    text.append("static ");
                }
                text.append(method.getReturnType())
                        .append(' ')
                        .append(method.getName())
                        .append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i != parameterTypes.length - 1) {
                        text.append(parameterTypes[i].getSimpleName()).append(',');
                    } else {
                        text.append(parameterTypes[i].getSimpleName());
                    }
                }
                text.append(')');
            }
            text.append("\n");
        }
        return text.toString();
    }
}

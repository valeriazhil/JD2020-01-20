package by.it.cherkas.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.printf("%s %s %s(", Modifier.toString(method.getModifiers()), method.getReturnType(), method.getName());
                String delimiter = "";
                for (Class<?> parameterType : method.getParameterTypes()) {
                    System.out.printf("%s%s", delimiter, parameterType.getName());
                    if (delimiter.equals("")) {
                        delimiter = ",";
                    }
                }
            }
            System.out.println(')');
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType(), field.getName());
            }
        }
    }
}
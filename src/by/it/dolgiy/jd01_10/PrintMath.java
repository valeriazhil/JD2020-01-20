package by.it.dolgiy.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC)==Modifier.PUBLIC) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Modifier.toString(1)).append(" ");
                stringBuilder.append(Modifier.toString(8)).append(" ");
                stringBuilder.append(method.getReturnType()).append(" ");
                stringBuilder.append(method.getName()).append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    stringBuilder.append(parameterType).append(",");
                }
                stringBuilder.append(")");
                String str = stringBuilder.toString().replace(",)",")");
                System.out.println(str);
            }
        }

        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC)==Modifier.PUBLIC)
                System.out.println(field.getType()+" "+field.getName());
        }
    }
}

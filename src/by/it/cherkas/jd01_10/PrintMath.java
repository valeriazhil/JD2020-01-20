package by.it.cherkas.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


     class PrintMath {
        public static void main(String[] args) throws IllegalAccessException, InstantiationException {
            Class<Math> mathClass = Math.class;
            Method[] methArr = mathClass.getDeclaredMethods();
            Field[] fieldArr = mathClass.getDeclaredFields();
            StringBuilder sb = new StringBuilder();

            for (Method m : methArr) {
                if (Modifier.isPublic(m.getModifiers())) {
                    sb.append(m).append("\n");
                }
            }

            for (Field f : fieldArr) {
                if (Modifier.isPublic(f.getModifiers())) {
                    sb.append(f).append("\n");
                }
            }

            Pattern pattern = Pattern.compile("java.lang.Math.");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                System.out.println(matcher.replaceAll(""));
            }
        }
    }

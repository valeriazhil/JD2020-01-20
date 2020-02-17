package by.it.zhilenkova.jd01.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Класс будет выводить все публичные метода класса Math
public class PrintMath {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Math> mathClass = Math.class;  //получили класс Math
        Method[] methArr = mathClass.getDeclaredMethods(); // получаем массив со всем методы данного класса Math
        Field[] fieldArr = mathClass.getDeclaredFields(); // получаем массив с инфой о переменных класса  Math
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




        /*
        материал из видео и из класса
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
            System.out.println(method);
        }

            for (Method method : methods) {
            StringBuilder out = new StringBuilder();

            if (Modifier.isPublic(method.getModifiers())) out.append("public ");
            if (Modifier.isStatic(method.getModifiers())) out.append("static ");
            out.append(method.getReturnType().getSimpleName()).append(' ');
            out.append(method.getName()).append('(');
            //дальше сами....
            System.out.println(out);
        }
        */


}

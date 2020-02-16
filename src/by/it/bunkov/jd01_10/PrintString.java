package by.it.bunkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

 class PrintString {

    public static void main(String[] args) {

         Class<String> aClass = String.class;
         Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if((method.getModifiers()  & Modifier.PUBLIC) ==Modifier.PUBLIC) {
                String res = method.toString().replace("java.lang.Math.", "");
                System.out.println(res);
            }
        }
    }
}


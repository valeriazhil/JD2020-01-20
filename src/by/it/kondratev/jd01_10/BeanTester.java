package by.it.kondratev.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object o = beanClass.newInstance();
        for (Method method : methods) {
            if (method.getDeclaredAnnotations()!=null) {
                method.invoke(method.getName());   // ????
                System.out.println(method.getName());
                System.out.println(method);
            }
        }
    }
}

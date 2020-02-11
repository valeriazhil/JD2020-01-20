package by.it.dolgiy.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class <Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }
}


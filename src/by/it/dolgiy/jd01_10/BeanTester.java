package by.it.dolgiy.jd01_10;

import jdk.internal.dynalink.beans.StaticClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class <Bean> beanClass = Bean.class;
        Bean bean = beanClass.newInstance();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)){
                Annotation annotation = declaredMethod.getAnnotation(Param.class);
                int a = ((Param) annotation).a();
                int b = ((Param) annotation).b();

                System.out.println(declaredMethod.getName());

            }
        }
    }
}


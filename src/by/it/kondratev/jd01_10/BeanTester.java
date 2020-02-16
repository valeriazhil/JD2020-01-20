package by.it.kondratev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Object o = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getDeclaredAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object result = null;
                if (Modifier.isStatic(method.getModifiers()) )
                    System.out.println(method.getName() +"   result="+method.invoke(null,a,b));
                else  System.out.println(method.getName() +"   result="+method.invoke(o,a,b));
            }
        }
    }
}

package by.it.dolgiy.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class <Bean> beanClass = Bean.class;
        Object object = beanClass.getDeclaredConstructor().newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object result;
                if (Modifier.isStatic(method.getModifiers())){
                    result = method.invoke(null, a, b);
                }
                else {
                    result = method.invoke(object, a, b);
                }
                System.out.println(method.getName()+" res="+result);
            }
        }
    }
}


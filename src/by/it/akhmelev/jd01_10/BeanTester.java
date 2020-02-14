package by.it.akhmelev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Object object = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object result;
                if (Modifier.isStatic(method.getModifiers())){
                    //static
                    result = method.invoke(null, a, b);
                }else
                {
                    //instance
                    result = method.invoke(object, a, b);
                }
                System.out.println(method.getName()+" res="+result);
            }
        }


    }

}

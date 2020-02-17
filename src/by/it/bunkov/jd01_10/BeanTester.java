package by.it.bunkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanCls = Bean.class;

        for (Method method : beanCls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                Object result;
                if (Modifier.isStatic(method.getModifiers())) {
                    result = method.invoke(null, param.a(), param.b());
                } else {
                    result = method.invoke(beanCls.newInstance(), param.a(), param.b());
                }

                System.out.println(method.getName());
                System.out.println(result);
            }
        }
    }

}
package by.it.gerasimov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Bean bean = beanClass.newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param ann = method.getAnnotation(Param.class);
                System.out.printf("Method: %s, result: ", method.getName());
                System.out.println(method.invoke(bean, ann.a(), ann.b()));
            }
        }
    }
}

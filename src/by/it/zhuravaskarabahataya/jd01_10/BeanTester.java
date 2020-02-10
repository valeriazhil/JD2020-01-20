package by.it.zhuravaskarabahataya.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//TaskC1. Создайтекласс BeanTester который в методе mainс сигнатурой,
// допускающей Exception: public static void main(String[] args) throws Exception
// создает экземпляр класса Bean (оператор new Bean( ) для этого использовать нельзя!),
// а затем находит и запускает его методы,
// помеченные созданной аннотацией с указанными в ней параметрами a и b.
// После каждого вызова invoke на консоль выводится имя найденного метода и результат запуска
class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClazz = Bean.class;  // объект типа Класс

         Method[] methods = beanClazz.getDeclaredMethods();
        Object bean = beanClazz.newInstance();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                System.out.println(method.getName());
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    System.out.println(method.invoke(null, param.a(), param.b()));
                } else {
                    System.out.println(method.invoke(bean, param.a(), param.b()));
                }
            }

        }
    }
}

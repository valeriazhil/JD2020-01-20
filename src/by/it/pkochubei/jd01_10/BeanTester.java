package by.it.pkochubei.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Bean myBean = null;
        Class testerClass = Class.forName(Bean.class.getName());
        myBean = (Bean) testerClass.newInstance();
        Method[] methods = myBean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                method.invoke(myBean,3,4);
                System.out.println("Started "+method.getName()+" "+method.invoke(myBean,3,4));
            }
        }
    }
}

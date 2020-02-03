package by.it.kondratev.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        System.out.println(res1(0.3, 756.13));
        System.out.println(res2(1.21, 0.371));
        res3();
    }

    private static void res3() {
        double x=12.1;
        double a;
        for (a = -5; a <=12 ; a+=3.75) {
            double f=pow(E,a*x) - 3.45*a;
            System.out.printf("При a=%-5.2f значение f будет равно %-10.5e",a,f);//(a+"      "+f);
            System.out.println();
        }

    }

    private static double res2(double a, double b) {
        double e = tan(pow((a+b),2));
        double c = cbrt(a+1.5);
        double f = a*pow(b,5);
        double d = b/log(a*a);
        double y = e-c+f-d;
        return (y);
    }

    private static double res1(double x,double a) {
        double b = cos(pow(x*x+PI/6, 5));
        double c = sqrt(x*a*a*a);
        double d = log(abs((a-1.12*x)/4));
        double z = b-c-d;
        return (z);
    }



}

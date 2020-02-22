package by.it.lomazki.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <=2; a=a+0.2) {
            double sum = 0;
            for (int x = 1; x <= 6; x++) {
                double y = pow(7,a) - cos(x);
                 sum = sum + y;
            }
            System.out.printf("%6s%5.2f %11s%5f \n", " При a=", a,"Сумма y = ",sum);
        }
    }

    private static void step2() {
        double a;
        double b;
        for (double x = -5.5; x < 2; x=x+0.5) {
            if (x/2 > -2 && x/2 <=-1) {
                 b = sin(x*x);
                 a = log10(abs(b+2.74));
                System.out.printf("%8s %5.2f %4s %f \n", "При x/2=",x/2,"a = ",a);
            }
            if (x/2 > -1 && x/2 < 0.2){
                 b = cos(x*x);
                 a = log10(abs(b+2.74));
                System.out.printf("%8s %5.2f %4s %f \n", "При x/2=",x/2,"a = ",a);
            }
            if (x/2==0.2) {
                 b = 1 / tan(x * x);
                 a = log10(abs(b + 2.74));
                System.out.printf("%8s %5.2f %4s %f \n", "При x/2=",x/2,"a = ",a);
            }
            else {
                System.out.printf("%8s %5.2f %24s \n", "При x/2=",x/2,"вычисления не определены");
            }
        }
    }
}

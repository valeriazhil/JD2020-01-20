package by.it.zhilenkova.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1(){
        double sum = 0;
        for (double a = 0; a <=2 ; a+=0.2) {
            for (int x = 1; x <=6; x++) {
                sum+= (pow(7,a)-cos(x));
            }
            System.out.printf("При a = %.2f Сумма = %f\n",a,sum);
        }
    }

    private static void step2(){
        double b = 0;
        double a;
        for (double x = -6; x < 2; x+=0.5){
            if ((x/2)>-2&&(x/2)<=-1){
                b=sin(x*x);
                printForStep2(b,x);
            }else if ((x/2)>-1&&(x/2)<0.2){
                b=cos(pow(x,2));
                printForStep2(b,x);
            }else if ((x/2)==0.2){
                b = 1.0/tan(x*x);
                printForStep2(b,x);
            }else {
                System.out.printf("для x= %1$f значения a и b не определены\n",x);
            }

        }


    }
    private static void printForStep2 (double b, double x){
        double a = log10(abs(b + (2.74)));
        System.out.printf("При x = %1$f  b = %2$f a = %3$f\n", x, b, a);
    }


}

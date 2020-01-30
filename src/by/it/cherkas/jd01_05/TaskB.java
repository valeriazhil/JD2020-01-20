package by.it.cherkas.jd01_05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.activation.ActivationGroup;
import java.sql.SQLOutput;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double b;
        double a;
        for (double i = -5.5; i < 2; i += 0.5) {
            double x = i / 2;
            if (-2 < x && x <= -1) {
                b = sin(x * x);
                a = abs(b + 2.74);
                a = log10(a);
                System.out.println("При x/2 = " + x + " a = " + a);
            } else if (-1 < x && x < 0.2) {
                b = cos(x * x);
                a = abs(b + 2.74);
                a = log10(a);
                System.out.println("При x/2 = " + x + " a = " + a);
            } else if (x == 0.2) {
                b = 1 / (tan(x * x));
                a = abs(b + 2.74);
                a = log10(a);
                System.out.println("При x/2 = " + x + " a = " + a);
            } else {
                System.out.println("При x/2 = " + x + " вычисления не определены");
            }
        }
    }


    private static void step1() {

        double result = 0;
        double sumxcos = 0;
        double x = 1;

        double xcos;
        for (int i = 0; i < 5; i++) {


            xcos = cos(toRadians(x));
            x++;
            sumxcos += xcos;

        }
        for (double a = 0; a <= 2; a += 0.2) {
            a = a * 1000;
            int ai = (int) Math.round(a);
            a = (double) ai / 1000;
            result = pow(7, a) - sumxcos;
            result = pow(7, a) - sumxcos;
            System.out.println("y=" + result + " for a = " + a + " сумма cos " + sumxcos + " 7^= " + pow(7, a));
        }






           /* if(a==0.0){
                result = pow(7,a)-sumxcos;
                result = pow(7,a)-sumxcos;
            }
            if(a==0.2){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==0.4){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==0.6){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==0.8){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==1.0){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==1.2){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==1.4){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==1.6){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==1.8){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
            if(a==2.0){
                result = pow(7,a)-sumxcos;
                System.out.println(result);
            }
        }*/
    }
}





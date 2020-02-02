package by.it.makarenko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
       Scanner sc = new Scanner(System.in);
       int mount = sc.nextInt();
        step2(mount);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);


    }
    private static void step1() {
        for (int i = 0; i <= 25 ; i++) {
            System.out.print(i+" ");
            if (i%5==0) System.out.println();

        }
    }

    private static void step2(int mount){
        String mountString;
        switch (mount){
            case 1: mountString = "январь";
            break;
            case 2: mountString = "февраль";
            break;
            case 3: mountString = "март";
            break;
            case 4: mountString="апрель";
            break;
            case 5: mountString="май";
            break;
            case 6: mountString="июнь";
            break;
            case 7: mountString="июль";
            break;
            case 8: mountString="август";
            break;
            case 9: mountString="сентябрь";
            break;
            case 10: mountString="октябрь";
            break;
            case 11: mountString="ноябрь";
            break;
            case 12: mountString="декабрь";
            break;
            default: mountString = "нет такого месяца";
            break;

        }
        System.out.println(mountString);
    }

    private static void step3(double a, double b, double c){
        double D = Math.pow(b,2) - (4*a*c);

        if (D<0) System.out.println("корней нет");
        else if (D==0){
            double x = -b/(2*a);
            System.out.println(x);
        }
            else{
            double x1 = (-b + Math.sqrt(D))/(2*a);
            double x2 = (-b - Math.sqrt(D))/(2*a);
            System.out.println(x1+" "+x2);
        }

    }
}

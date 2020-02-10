package by.it.zhilenkova.jd01.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число от 1 до 12");
        int month=scanner.nextInt();

        System.out.println("Введите коэффициент a квадратного уравнения");
        double a=scanner.nextDouble();
        System.out.println("Введите коэффициент b квадратного уравнения");
        double b=scanner.nextDouble();
        System.out.println("Введите коэффициент c квадратного уравнения");
        double c=scanner.nextDouble();


        step1();
        step2(month);
        step3(a, b, c);
    }

    private static void step1() {
        int i=0;
        int j=0;
        int a=1;
        while (a<26){
            for (i=0;i<4;i++){
                System.out.print(a+" ");
                a++;
            }
            System.out.println(a);
            a++;
        }
    }

    private static void step2(int month) {
        switch (month){
            case 1:{
                System.out.println("январь");
                break;
            }
            case 2:{
                System.out.println("февраль");
                break;
            }
            case 3:{
                System.out.println("март");
                break;
            }
            case 4:{
                System.out.println("апрель");
                break;
            }
            case 5:{
                System.out.println("май");
                break;
            }
            case 6:{
                System.out.println("июнь");
                break;
            }
            case 7:{
                System.out.println("июль");
                break;
            }
            case 8:{
                System.out.println("август");
                break;
            }
            case 9:{
                System.out.println("сентябрь");
                break;
            }
            case 10:{
                System.out.println("октябрь");
                break;
            }
            case 11:{
                System.out.println("ноябрь");
                break;
            }
            case 12:{
                System.out.println("декабрь");
                break;
            }
            default:{
                System.out.println("нет такого месяца");
            }
        }


    }

    private static void step3(double a, double b, double c) {
        double d = (b*b-4*a*c);
        System.out.println(d);
        if (d>0){
            double x1 = (-b-Math.sqrt(d))/(2*a);
            double x2 = (-b+Math.sqrt(d))/(2*a);
            System.out.println("корни квадратного уравнения: "+x1+" "+x2);
        }
        if (d==0){
            double x = -b/(2*a);
            System.out.println("корень квадратного уравнения "+x);
        }
        if (d<0){
            System.out.println("корней нет");
        }
    }
}

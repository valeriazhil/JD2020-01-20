package by.it.pkochubei.jd01_02;
import java.util.Scanner;
public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scan= new Scanner(System.in);
            int month = scan.nextInt();
            step2(month);
    }
    private static void step1(){
        for (int i =1; i <=25 ; i++) {
            if (i % 5==0)
                    System.out.print(i+ " ");
        }
        System.out.println();
    }
    static void step2(int month){
            switch (month){
                case 1:
                    System.out.println("Январь");
                    break;
                case 2:
                    System.out.println("Февраль");
                    break;
                case 3:
                    System.out.println("Март");
                    break;
                case 4:
                    System.out.println("Апрель");
                    break;
                case 5:
                    System.out.println("Май");
                    break;
                case 6:
                    System.out.println("Июнь");
                    break;
                case 7:
                    System.out.println("Июль");
                    break;
                case 8:
                    System.out.println("Август");
                    break;
                case 9:
                    System.out.println("Сентябрь");
                    break;
                case 10:
                    System.out.println("Октябрь");
                    break;
                case 11:
                    System.out.println("Ноябрь");
                    break;
                case 12:
                    System.out.println("Декабрь");
                    break;
                default:
                    System.out.println("Нет такого месяца");

            }
    }

    }

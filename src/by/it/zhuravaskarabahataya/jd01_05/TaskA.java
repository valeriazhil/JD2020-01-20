package by.it.zhuravaskarabahataya.jd01_05;
import static java.lang.Math.*;
// один вопрос
public class TaskA {
    public static void main(String[] args) {
        double a = 756.13;
        double x = 0.3;
        System.out.println(task1oneLine(a, x));
        System.out.println(task1separate(a, x));

        double a2 = 1.21;
        double b2 = 0.371;
        System.out.println(task2(a2, b2));

        double x3 = 12.1;
        double deltaA = 3.75;
        task3(x3, deltaA);
    }

    private static void task3 (double x, double deltaA){

        for (double a = -5; a <= 12; a+=deltaA ) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("%-10s%-8.4f %2s %-8.4f\n","При a = ", a, "f = ", f); //а как красиво сделать??

        }
    }

    private static double task2 ( double a, double b){
        return tan(pow(a+b, 2)) - cbrt(a+ 1.5) +a*pow(b, 5) - b/log(a*a);

    }

    private static double task1separate (double a, double x){
        double part1 = cos(pow(x*x + PI/6, 5));
        double part2 = sqrt(x*pow(a, 3));
        double part3 = log(abs((a-1.12*x)/4));
        return part1 - part2 - part3;

    }

    private static double task1oneLine (double a, double x){
        return cos(pow(x*x + PI/6, 5)) - sqrt(x*pow(a, 3)) - log(abs((a-1.12*x)/4));

    }

}

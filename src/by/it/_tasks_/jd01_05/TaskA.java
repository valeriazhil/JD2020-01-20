package by.it._tasks_.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        TaskA2();
        TaskA3();

        double a = 756.13;
        double x = 0.3;
        double z = Math.cos(Math.pow(x*x+Math.PI/6,5))-Math.sqrt(x*Math.pow(a,3)) - Math.log((a-1.12*x)/4);
        System.out.println(z);
    }
    static void TaskA2(){
        double a = 1.21;
        double b = 0.371;
        double y = Math.tan(Math.pow(a+b,2)) - Math.cbrt(a+1.5) + a*Math.pow(b,5)- b/Math.log(Math.pow(a,2));
        System.out.println(y);
    }
    static void TaskA3(){
        double x =12.1;
        for (double a = -5; a <12 ; a = a+3.75) {
            double f = Math.pow(Math.E,a*x) - 3.45*a;
            System.out.println("При a= "+a+ " " +"f= "+f);
        }
    }
}

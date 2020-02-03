package by.it.dolgiy.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        control_task_1();
        control_task_2();
        control_task_3();
    }

    private static void control_task_1() {
        double a = 756.13;
        double x = 0.3;
        double cos = Math.cos(Math.pow ((x*x+Math.PI/6.0),5));
        double sqr = Math.sqrt(x*a*a*a);
        double ln = Math.log(Math.abs((a-1.12*x)/4.0));
        double z = cos - sqr - ln;
        System.out.println(z);
    }

    private static void control_task_2() {
        double a = 1.21;
        double b = 0.371;
        double tg = Math.tan(Math.pow((a+b),2));
        double sqr = Math.cbrt(a+1.5);
        double ab = a*Math.pow(b,5);
        double ln = b/Math.log(a*a);
        double y = tg - sqr + ab -ln;
        System.out.println(y);
    }

    private static void control_task_3() {
        double x = 12.1;
        double da = 3.75;
        for (double a = -5; a <=12 ; a+=da) {
            double f = Math.exp(a*x)-3.45*a;
            System.out.print("При а = "+a+" f = "+f +'\n');
        }
    }

}

package by.it._tasks_.jd01_05;


public class TaskB {
    public static void main(String[] args) {


        for (double a = 0; a <=2 ; a=a+0.20) {
            double sum = 0;
            for (int x = 1; x <=6; x++) {
                sum+= Math.pow(7,a) - Math.cos(x);
                System.out.printf("При a=%.2f Сумма y =%f%n",a, sum);
            }
        }
    }

}

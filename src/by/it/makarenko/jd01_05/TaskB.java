package by.it.makarenko.jd01_05;


public class TaskB {
    public static void main(String[] args) {
//       TaskB2();


        for (double a = 0; a <=2 ; a=a+0.20) {
            double sum = 0;
            for (int x = 1; x <=6; x++) {
                sum+= Math.pow(7,a) - Math.cos(x);
                System.out.printf("При a=%.2f Сумма y =%f%n",a, sum);
            }
        }

    }
// static void TaskB2(){

//     for (double x = -6; x < 2 ; x=x+0.5) {
//         double alf = Math.log10(Math.abs(beta +2.74));
//         if ()
//     }

}


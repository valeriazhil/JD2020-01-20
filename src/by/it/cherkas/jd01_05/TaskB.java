package by.it.cherkas.jd01_05;





import static java.lang.Math.*;

 class TaskB {

    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {

        for (double a = 0; a <= 2; a = a + 0.2) {
            double sum = 0;

            for (int x = 1; x <= 6; x = x + 1) {

                sum = sum + (pow(7, a) - cos(x));
                System.out.printf("При а = %2.1f   x = %d   y = %5.4f\n", a, x, sum);

            }
        }
    }


    private static void step5() {
        double b;
        for (double x = -6; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
            } else if (x / 2 == 0.2) {
                b = 1 / tan((x * x));
            } else {
                System.out.printf("При x/2 = %2.2f     x = ^^^\n", x, x);
                continue;

            }
            double a = log10(abs(b + 2.74));
            System.out.printf("При x/2 = %2.2f   a = %7.7f\n", x, a);

        }
    }

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







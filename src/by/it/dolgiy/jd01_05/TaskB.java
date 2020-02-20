package by.it.dolgiy.jd01_05;

class TaskB {
    public static void main(String[] args) {
        control_task_4();
        control_task_5();
    }

    private static void control_task_4() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double e = 0;
            for (int x = 1; x <= 6; x++) {
                double y = (Math.pow(7,a)-Math.cos(x));
                e = e + y;
            }
            System.out.println("При а = "+a+" Сумма y = "+e);
        }
        System.out.println();
    }

    private static void control_task_5() {
        for (double x = -6; x < 2.0; x = x + 0.5) {
            if ((x/2) <= -2){
                System.out.println("При x/2="+(x/2)+" вычисления не определены");
            }
            if (-2 < (x/2) && (x/2) <= -1){
                double a = Math.log10(Math.abs(Math.sin(x*x) + 2.74));
                System.out.println("При x/2="+(x/2)+" a = "+a);
            }
            if (-1 < (x/2) && (x/2) < 0.2){
                double a = Math.log10(Math.abs(Math.cos(x*x) + 2.74));
                System.out.println("При x/2="+(x/2)+" a = "+a);
            }
            if ((x/2) == 0.2){
                double a = Math.log10(Math.abs((1/(Math.tan(x*x))) + 2.74));
                System.out.println("При x/2="+(x/2)+" a = "+a);
            }
            if ((x/2) > 0.2){
                System.out.println("При x/2="+(x/2)+" вычисления не определены");
            }
        }
    }

}


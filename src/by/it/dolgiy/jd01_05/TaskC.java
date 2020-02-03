package by.it.dolgiy.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        double[] mas = new double[(int) (Math.random() * 20+20)];
        for (int i = 0; i < mas.length; i++) {
            for (double x = 5.33; x <= 9; x += 0.25) {
                double z = Math.cbrt(x * x + 4.5);
                mas[i] = z;
                System.out.println(mas[i]);
            }

        }
    }
}
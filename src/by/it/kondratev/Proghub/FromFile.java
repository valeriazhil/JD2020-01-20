package by.it.kondratev.Proghub;

import java.io.*;

public class FromFile {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int n = 0;
        double sum = 0;

        System.out.print("Введите количество чисел: ");
        s = br.readLine();
        try {
            n = Integer.parseInt(s); }
        catch (NumberFormatException e) {
            System.out.println("Ошибка формата ввода, повторите снова.");
        }

        try {
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(br.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата ввода, повторите снова.");
        }

        System.out.println("Среднее арифметическое равно: " + sum/n);

    }
}

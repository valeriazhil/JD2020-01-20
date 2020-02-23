package by.it.gerasimov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

class TaskC {

    static Scanner sc;

    static void readData() throws InterruptedException {
        ArrayList<Double> numbers = new ArrayList<>();
        int errorCount = 0;
        while (true) {
            try {
                String str = sc.nextLine();
                numbers.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {
                if (errorCount < 5) {
                    Thread.sleep(100);
                    for (int i = numbers.size() - 1; i >= 0; i--) {
                        System.out.print(numbers.get(i) + " ");
                    }
                    errorCount++;
                } else {
                    throw e;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }
}

package by.it.kondratev.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData() {
        LinkedList<Double> storage = new LinkedList<>();
        double n = 0; double m = 0;
        for (int i = 1; i < 6; i++) {
            try {
                while (true) {
                    String str = scanner.nextLine();
                    m = Double.parseDouble(str);
                    storage.add(m);

                }

            } catch (NumberFormatException e) {
                sleep();
                for (int j = storage.size() - 1; j >= 0; j--) {
                    n = storage.getLast();
                    System.out.print(storage.removeLast() + " ");
                    storage.addFirst(n);
                }
                System.out.println();

            }

        }
        throw new NumberFormatException();
    }

    static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}





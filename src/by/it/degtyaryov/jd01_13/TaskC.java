package by.it.degtyaryov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskC {

    private static Scanner scanner;
    private static List<Double> inputedNums = new ArrayList<>();
    private static int countError;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    private static void readData() throws InterruptedException {
        String line = scanner.nextLine();
        try {
            double number = Double.parseDouble(line);
            inputedNums.add(number);
        } catch (NumberFormatException e) {
            Thread.sleep(100);
            countError++;
            if (countError > 5) {
                throw e;
            }
            printStackNums();
        }
    }

    private static void printStackNums() {
        if (inputedNums.size() <= 0) {
            return;
        }
        for (int i = inputedNums.size() - 1; i >= 0; i--) {
            System.out.print(inputedNums.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

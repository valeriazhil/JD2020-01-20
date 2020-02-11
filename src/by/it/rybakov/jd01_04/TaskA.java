package by.it.rybakov.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        System.out.println();
//        Arrays.binarySearch();

        Helper.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) first = i;
            if (array[i] == last) last = i;
        }
        InOut.printArray(array, "V", 4);
        System.out.printf("%s=%1.0f", "Index of first element", first);
        System.out.println();
        System.out.printf("%s=%1.0f", "Index of last element", last);

    }
}




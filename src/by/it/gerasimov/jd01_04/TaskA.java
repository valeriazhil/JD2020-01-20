package by.it.gerasimov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        printByColumns(array, 5);
        sort(array);
        printByColumns(array, 4);
        int indexFirst = Arrays.binarySearch(array, first);
        int indexLast = Arrays.binarySearch(array, last);
        System.out.printf("Index of first element=%d\nIndex of last element=%d\n", indexFirst, indexLast);
    }

    static void printByColumns(double[] array, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("V[%02d]=%-5.1f ", i, array[i]);
            if (((i + 1) % columnCount == 0 && i != 0) || i == array.length - 1) {
                System.out.println();
            }
        }
    }

    static void sort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while ((j > 0) && (arr[j] < arr[j - 1])) {
                double temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}

package by.it.degtyaryov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        buildOneDimArray(scanner.nextLine());
    }

    /**
     * Выводит таблицу умножения в консоль
     *
     * @author DEA
     */
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    /**
     * Метод выводит в консоль: массив полученный из строки, отсортированный массив,
     * индексы в отсортированном массиве первого и последнего элементов исходного массива
     *
     * @param line строка, содержащая числа типа double, разделенные пробелом
     * @author DEA
     */
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        System.out.printf("Index of first element=%d%n", Arrays.binarySearch(array, first));
        System.out.printf("Index of last element=%d", Arrays.binarySearch(array, last));
    }
}
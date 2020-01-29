package by.it.degtyaryov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        buildOneDimArray(scanner.nextLine());
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
        // сортировка слиянием
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        // поиск индексов первого и последнего элементов исходного массива по собственному алгоритму поиска
        System.out.printf("Index of first element=%d%n", binarySearch(array, first));
        System.out.printf("Index of last element=%d", binarySearch(array, last));
    }

    /**
     * Сортирует массив методом слияния
     *
     * @param array массив для сортировки
     * @author DEA
     */
    static void mergeSort(double[] array) {
        double[] sortedArray = mergeSortArray(array);
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    /**
     * Бинарный поиск элемента в отсортированном массиве
     *
     * @param sortedArray отсортированный по возрастанию массив для поиска
     * @param value       искомый элемент
     * @return индекс по которому найден искомый элемент, иначе "-1"
     * @author DEA
     */
    static int binarySearch(double[] sortedArray, double value) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (sortedArray[middle] == value) {
                return middle;
            } else {
                if (sortedArray[middle] < value) {
                    left = middle + 1;
                }
                if (sortedArray[middle] > value) {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    private static double[] mergeSortArray(double[] array) {
        double[] sortedArray = Arrays.copyOf(array, array.length);
        if (sortedArray.length > 1) {
            int middle = (array.length) / 2;
            double[] part1 = Arrays.copyOfRange(sortedArray, 0, middle);
            double[] part2 = Arrays.copyOfRange(sortedArray, middle, sortedArray.length);
            sortedArray = merge(mergeSortArray(part1), mergeSortArray(part2));
        }
        return sortedArray;
    }

    private static double[] merge(double[] part1, double[] part2) {
        int indexPart1 = 0;
        int indexPart2 = 0;
        double[] result = new double[part1.length + part2.length];

        for (int i = 0; i < result.length; i++) {
            if (indexPart1 == part1.length) {
                result[i] = part2[indexPart2++];
            } else if (indexPart2 == part2.length) {
                result[i] = part1[indexPart1++];
            } else {
                result[i] = (part1[indexPart1] < part2[indexPart2]) ? part1[indexPart1++] : part2[indexPart2++];
            }
        }
        return result;
    }
}
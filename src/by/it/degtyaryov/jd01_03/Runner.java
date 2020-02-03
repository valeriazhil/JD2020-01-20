package by.it.degtyaryov.jd01_03;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        // Проверка получения массива из строки
        String sample = "1 2 3 66 88 0";
        System.out.println(Arrays.toString(InOut.getArray(sample)));

        // Вывод полученного массива просто и с форматированием
        InOut.printArray(InOut.getArray(sample));
        InOut.printArray(InOut.getArray(sample), "A", 2);
        InOut.printArray(InOut.getArray(sample), "B", 3);

        // Сортировка массива и поиск минимума и максимума
        double[] array = new double[]{1.0, 1.1, 2.0, 5, 0, -2, 5};
        System.out.printf("Минимальное значение в массиве: %.2f%n", Helper.findMin(array));
        System.out.printf("Максимальное значение в массиве: %.2f%n", Helper.findMax(array));
        Helper.sort(array);
        System.out.printf("Отсортированный массив: %s%n%n", Arrays.toString(array));

        // ЗАДАНИЕ С1: Умножение матрицы на вектор
        double[][] matrix = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[] vector = {1, 2, -1};
        double[] vectorResult = Helper.mul(matrix, vector);

        System.out.printf("%s * %s = %s%n%n", Arrays.deepToString(matrix),
                Arrays.toString(vector), Arrays.toString(vectorResult));

        // ЗАДАНИЕ С2: Умножение матрицы на матрицу
        double[][] matrixLeft = {{1, 2, 1}, {0, 1, 2}};
        double[][] matrixRight = {{1, 0}, {0, 1}, {1, 1}};
        double[][] matrixResult = Helper.mul(matrixLeft, matrixRight);

        System.out.printf("%s * %s = %s%n", Arrays.deepToString(matrixLeft),
                Arrays.deepToString(matrixRight), Arrays.deepToString(matrixResult));
    }

}

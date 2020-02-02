package by.it.degtyaryov.jd01_04;

/**
 * Вспомогательный класс для работы с массивами
 *
 * @author DEA
 */
class Helper {

    /**
     * Поиск минимального значения в массиве
     *
     * @param array массив для поиска минимального значения
     * @return минимальное значение в переданном массиве
     * @author DEA
     */
    static double findMin(double[] array) {
        double min = (array.length > 0) ? array[0] : 0;
        for (double i : array) {
            min = Math.min(min, i);
        }
        return min;
    }

    /**
     * Поиск максимального значения в массиве
     *
     * @param array массив для поиска максимального значения
     * @return максимальное значение в переданном массиве
     * @author DEA
     */
    static double findMax(double[] array) {
        double max = (array.length > 0) ? array[0] : 0;
        for (double i : array) {
            max = Math.max(max, i);
        }
        return max;
    }

    /**
     * Сортировка массива по возрастанию
     *
     * @param array массив для сортировки
     * @author DEA
     */
    static void sort(double[] array) {
        boolean wasChanged = true;
        int tillIndex = array.length - 1;

        while (wasChanged) {
            wasChanged = false;
            for (int j = 0; j < tillIndex; j++) {
                if (array[j] > array[j + 1]) {
                    wasChanged = true;
                    double buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
    }

    /**
     * Умножение матрицы на вектор
     *
     * @param matrix матрица для умножения
     * @param vector вектор для умножения
     * @return вектор, полученный в результате умножения матрицы на вектор
     * @author DEA
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] vectorResult = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                vectorResult[i] += matrix[i][j] * vector[j];
            }
        }
        return vectorResult;
    }

    /**
     * Умножение матрицы на матрицу
     *
     * @param matrixLeft  левая матрица для умножения
     * @param matrixRight правая матрица для умножения
     * @return матрица, полученная в результате умножения левой матрицы на правую матрицу
     * @author DEA
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixResult = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixResult[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrixResult;
    }
}

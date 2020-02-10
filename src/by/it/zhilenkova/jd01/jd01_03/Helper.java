package by.it.zhilenkova.jd01.jd01_03;

public class Helper {
    /**
     * Метод для поиска минимума в массиве типа double
     * @param arr - массив чисел типа double
     * @return минимальное число типа double
     */

    public static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Метод для поиска максимума в массиве типа double
     * @param arr - массив чисел типа double
     * @return максимальное число типа double
     */

    public static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Метод для сортировка массива типа double
     * @param arr - массив чисел типа double
     */

    public static void sort(double[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for(int k = i + 1; k < arr.length; k++){
                if(arr[k] < arr[i]){
                    double tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    /**
     * Метод для умножения матрицы на вектор типа double
     * @param matrix - двумерный массив чисел типа double (матрица)
     * @param vector - массив чисел типа double (вектор)
     * @return массив чисел типа double (вектор)
     */

    public static double[] mul(double[][] matrix, double[] vector){
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                result[i] = result[i] + matrix[i][k] * vector[k];
            }
        }
        return result;
    }

    /**
     * Метод для умножения матрицы на матрицу типа double
     * @param matrixLeft - двумерный массив чисел типа double (матрица 1)
     * @param matrixRight - двумерный массив чисел типа double (матрица 2)
     * @return двумерный массив чисел типа double (вектор)
     */

    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];

        for (int j = 0; j < matrixLeft.length; j++) {
            for (int i = 0; i < matrixRight[0].length; i++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[j][i] = result[j][i] + matrixLeft[j][k] * matrixRight[k][i];
                }
            }
        }
        return result;
    }

}

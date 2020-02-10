package by.it.rybakov.jd01_04;

public class Helper {
    static double findMin(double[ ] arr){
        double [] array=arr;
        double min=0;
        for (double element : arr) {
            if (min>element)
                min=element;
        }

        return min;
    }

    static double findMax(double[ ] arr){
        double[] array=arr;
        double max=0;
        for (double element : arr) {
            if (max<element)
                max=element;
        }

        return max;
    }

    static void sort(double[] arr){
        double[] array = arr;
        int changerCounter = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double buffer = array[i];
                    array[i] = array[j];
                    array[j] = buffer;
                }
            }
            System.out.printf("%3s[%1d]=%-4.2f", "A", i, array[i]);
        }
    }
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;

    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return result;
    }

}



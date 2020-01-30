package by.it.cherkas.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) min = i;
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) max = i;
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

   /* static double[] mul(double[][] matrix, double[] vector) {
        double[] arr = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                arr[i] = arr[i] + matrix[i][j] + vector[j];


            }
        }
    }*/

   /* static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] arr = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j <matrixRight[0].length ; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    arr[i][j] = arr[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
    }*/
}

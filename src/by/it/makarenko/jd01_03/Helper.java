package by.it.makarenko.jd01_03;


import java.util.Arrays;


class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
            System.out.println(min+" ");
        }
        return min;
    }
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
            System.out.println(max+" ");
        }

        return max;
    }
            static void sort(double[] arr){
                Arrays.sort(arr);
                System.out.print(arr);
            }

    static double[] mul(double[][] matrix, double[] vector){
        double [] matrVect = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <vector.length ; j++) {
                matrVect[i]= matrVect[i] +matrix[i][j]*vector[j];
            }
        }
        return matrVect;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double [][] allMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixRight[0].length  ; j++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    allMatrix[i][j] = allMatrix[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                    
                }
            }
        }
        return allMatrix;
    }

}
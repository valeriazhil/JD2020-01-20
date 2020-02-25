package by.it.dolgiy.jd01_03;

class Helper {

    static double findMin(double[ ] arr){
        if (0==arr.length){
            return Double.MIN_VALUE;
        }
        else{
            double min = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (min>arr[i]){
                    min=arr[i];
                }
            }
            return min;
        }
    }

    static double findMax(double[ ] arr){
        if (0==arr.length){
            return Double.MAX_VALUE;
        }
        else{
            double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max<arr[i]){
                    max=arr[i];
                }
            }
            return max;
        }
    }

    static void sort(double[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                double sort = arr [i];
                arr[i] = arr[j];
                arr[j] = sort;
                }
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] mp = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mp[i] = mp[i] + matrix[i][j] * vector[j];
            }
        }
        return mp;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] mp = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    mp[i][j] = mp[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return mp;
    }

}


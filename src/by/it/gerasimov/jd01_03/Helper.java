package by.it.gerasimov.jd01_03;

class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double v : arr) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double v : arr) {
            if (v > max) {
                max = v;
            }
        }
        return max;
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

    static double[] mul(double[][] a, double[] b) {
        double[] m = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                m[i] += a[i][j] * b[j];
            }
        }
        return m;
    }

    static double[][] mul(double[][] a, double[][] b) {
        double[][] m = new double[a.length][b[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    m[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return m;
    }

}

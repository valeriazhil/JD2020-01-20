package by.it.gerasimov.jd01_04;

class TaskC {

    static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    static void mergeSort(double[] array, int left, int right) {
        if (right > left) {
            int m = (right - left) / 2;
            mergeSort(array, left, left + m);
            mergeSort(array, left + m + 1, right);
            double[] array1 = new double[m + 1];
            double[] array2 = new double[right - left - m];
            for (int i = left; i <= left + m; i++) {
                array1[i - left] = array[i];
            }
            for (int i = left + m + 1; i <= right; i++) {
                array2[i - left - m - 1] = array[i];
            }
            double[] arraySort = merge(array1, array2);
            for (int i = 0; i < arraySort.length; i++) {
                array[left + i] = arraySort[i];
            }
        }
    }

    static double[] merge(double[] array1, double[] array2) {
        double[] array = new double[array1.length + array2.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (k >= array1.length) {
                array[i] = array2[j];
                j++;
            } else if (j >= array2.length) {
                array[i] = array1[k];
                k++;
            } else if (array1[k] < array2[j]) {
                array[i] = array1[k];
                k++;
            } else {
                array[i] = array2[j];
                j++;
            }
        }
        return array;
    }

    static int binarySearch(double[] array, double value) {
        int m = array.length / 2;
        int index = -1;
        if (array[m] > value) {
            double[] arrayLeft = new double[m];
            for (int i = 0; i < m; i++) {
                arrayLeft[i] = array[i];
            }
            index = binarySearch(arrayLeft, value);
        } else if (array[m] < value) {
            double[] arrayRight = new double[array.length - m - 1];
            for (int i = 0; i < array.length - m - 1; i++) {
                arrayRight[i] = array[m + i + 1];
            }
            index = m + 1 + binarySearch(arrayRight, value);
        } else if (array[m] == value) {
            index = m;
        }
        return index;
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        TaskA.printByColumns(array, 5);
        mergeSort(array);
        TaskA.printByColumns(array, 4);
        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);
        System.out.printf("Index of first element=%d\nIndex of last element=%d\n", indexFirst, indexLast);
    }

    public static void main(String[] args) {
        String line = "-12.765585994437613 -10.344101033797257 -2.690339095005644 -1.917999606931323 0.2001187892668561 1.175102597010742 1.8818515371146205 2.4835288305138263 3.210212423548054 4.123509250188704 7.328628807307883 10.870488605826772 13.203266034537371 14.870580607358281 15.136843359201318";
        buildOneDimArray(line);
    }
}

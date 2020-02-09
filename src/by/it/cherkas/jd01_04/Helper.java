package by.it.cherkas.jd01_04;
// класс хелпер
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
        do{
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j+1]){
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    swap = true;
                }
            }
            last --;
        }
        while (swap);
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

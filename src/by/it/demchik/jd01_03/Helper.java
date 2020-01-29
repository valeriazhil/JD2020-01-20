package by.it.demchik.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                min = arr[i];


            }
        }
        System.out.println(min);

        return (min);
    }


    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] > arr[i]) {
                max = i;
            }
            System.out.println(" " + max);
        }
        return max;

    }


    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                }


            }
        }
    }

}











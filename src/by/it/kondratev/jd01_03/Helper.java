package by.it.kondratev.jd01_03;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Helper {

    static double findMin(double[ ] arr) {
        double min=arr[1];
        for (double v : arr) { if(v<min) min=v;}
        return min;
    }

    static double findMax(double[ ] arr) {
        double max=arr[1];
        for (double v : arr) { if(v>max) max=v;}
        return max;
    }

    public static void sort(double[ ] arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            double min = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[i]) {
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;    }
        }
    }

    public static void sort(int[][] arr){        //сортировка матрицы по первому элементу строки
        for (int i = 0; i < arr.length-1 ; i++) {
            int [] min = Arrays.copyOf(arr[0],arr[0].length);
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j][0] < arr[i][0]) {
                    min = Arrays.copyOf(arr[j],arr[j].length);
                    arr[j] = Arrays.copyOf(arr[i],arr[i].length);;
                    arr[i] = Arrays.copyOf(min,min.length);    }
        }
    }
}

package by.it.pkochubei.jd01_04;

public class Helper {
    static double findMin(double[ ] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                arr[i]=min;
            }
            System.out.println(min+" ");
        }
        return min;
    }
    static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                arr[i]=max;
            }
            System.out.println(max+" ");
        }
        return max;
    }
    static void sort(double[ ] arr){
        for (double i = arr.length-1; i>= 0; i--) {
            for (int j = 0; j <i ; j++) {
                if( arr[j] > arr[j+1] ){
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                }
            }
        }
    }
}

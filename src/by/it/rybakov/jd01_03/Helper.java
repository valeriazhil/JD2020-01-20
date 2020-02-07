package by.it.rybakov.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (double element : arr) {
            if (min>element)
                min=element;
        }

        return min;
    }

    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double element : arr) {
            if (max<element)
                max=element;
        }

        return max;
    }

    static void sort(double[] array){
        int last=array.length-1;
        boolean ok;
        do {
            ok=true;
            for (int i = 0; i < last; i++) {
                if (array[i]>array[i+1]){
                    ok=false;
                    double tmp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=tmp;
                }
            }
            last--;
        }while (!ok);
    }


}

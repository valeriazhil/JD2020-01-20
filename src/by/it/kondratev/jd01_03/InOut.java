package by.it.kondratev.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {


    static double[] getArray(String line) {
        line = line.trim();
        String[] strArr = line.split(" ");
        int count = strArr.length;
        double[] mas = new double[count];
        for (int i = 0; i < count; i++) {
            mas[i] = Double.parseDouble(strArr[i]);
        }
        return mas;
    }

    static void printArray(double[ ] arr) {
        for (double v : arr) {
        //for (int i = 0; i <arr.length ; i++) {
        //    System.out.print(arr[i]+" ");
            System.out.print(v +" ");
                    }
        System.out.println();

    }

    public static void printArray(double[ ] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("%s[% -3d]=%-5.2f  ", name,i, arr[i]);
            if((i+1)%columnCount==0) System.out.println();
        }
        System.out.println();

    }

}









package by.it.kondratev.jd01_04;

import by.it.kondratev.jd01_03.Helper;
import by.it.kondratev.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String  str = scanner.nextLine();
        String str="3 4 56 7 43 65 7 32 1 5 55 48 97 99";
        buildOneDimArray(str);
    }

    static void buildOneDimArray(String line){
        line = line.trim();
        String[] strArr = line.split(" ");
        int count = strArr.length;
        double[] mas = new double[count];
        for (int i = 0; i < count; i++) {
            mas[i] = Double.parseDouble(strArr[i]);
        }

        System.out.println("До сортировки");
        InOut.printArray(mas,"V",2);
        mergeSort(mas);
        System.out.println("\nОтсортированный массив");
        InOut.printArray(mas,"V",2);
    }

    static void mergeSort(double[ ] array) {
        int left = 0; int right = array.length-1;
        mergeSort(array,left,right);
    }

    private static void mergeSort(double[ ] array, int l,  int r) {
        if (l >= r) return;
        int m = (r + l) / 2;
        double[] part1 = new double[m - l + 1];
        int k = 0;
        for (int i = l; i <= m; i++) {
            part1[k] = array[i];
            k++;
        }
        double[] part2 = new double[r - m];
        k = 0;
        for (int i = m + 1; i <= r; i++) {
            part2[k] = array[i];
            k++;
        }
        mergeSort(part1);
        mergeSort(part2);
        double[] massive = merge_my(part1, part2);
        for (int i = l; i < r; i++) {
            array[i] = massive[i - l];
        }
    }



    //private static double[ ] merge(double[ ] part1, double[ ] part2){
     //   double [] mas = new double[part1.length+part2.length];
     //   int index1 = 0;
      //  int index2 = 0;
      //  int i=0;
       // while (i<mas.length){
       //     if(index1<part1.length && (index2 == part2.length || part1[index1]<part2[index2]))
        //        mas[i++] = part1[index1++];
         //   else  mas[i++] = part2[index2++];
        //}
        //return mas;
    //}

    private static double[ ] merge_my(double[ ] part1, double[ ] part2){
        double [] mas = new double[part1.length+part2.length];
        int i=0; int j=0; int k=0;
        while(i<part1.length || j<part2.length) {
            if(part1[i]<part2[j]) {
                mas[k] = part1[i]; i++;
                if(i==part1.length) {
                    do {
                        k++;
                        mas[k] = part2[j];
                        j++;}
                    while (j < part2.length) ;
                    break;
                }
            }
            else { mas[k] = part2[j]; j++;
                if(j==part2.length) {
                    do {
                        k++;
                        mas[k] = part1[i];
                        i++;}
                    while (i < part1.length) ;
                    break;}
            }
            k++;
        }
        return mas;
    }

}

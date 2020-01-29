package by.it.zhuravaskarabahataya.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void printMulTable(){
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int firstIndex = Arrays.binarySearch(array, firstElement);
        int lastIndex = Arrays.binarySearch(array, lastElement);
        System.out.println("Index of first element=" + firstIndex);
        System.out.println("Index of last element=" + lastIndex);
    }
}



package by.it.zhilenkova.jd01.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

public static void main(String[] args)  {
    printMulTable();
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        double first = array[0];
        double last = array[array.length-1];

        //System.out.printf("Index of first element=%d\n", Arrays.binarySearch(array,first));
        // System.out.printf("Index of last element=%d\n", Arrays.binarySearch(array,last));

        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }



}

package by.it.lomazki.Example.jd01_04;

import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length-1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int element = 0; element < array.length-1; element++) {
            if (array[element] == start) {
                System.out.println("Index of first element=" + element);
                break;
            }
            if (array[element] == stop) {
                System.out.println("Index of last element=" + element);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.nextLine();
        buildOneDimArray (str);
    }
}

package by.it.anackij.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        System.out.println();
//        Arrays.binarySearch();

        Helper.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) first = i;
            if (array[i] == last) last = i;
        }
        InOut.printArray(array, "V", 4);
        System.out.printf("%s=%1.0f", "Index of first element", first);
        System.out.println();
        System.out.printf("%s=%1.0f", "Index of last element", last);

    }

    static void mergeSort(int[] array){
        int left=0;
        int right=array.length;
        int medium=array.length/2;
        for (int i = 0; i < array.length; i++) {
            while (left<=right){
                medium = (left+right)/2;
            }
        }
    }
}

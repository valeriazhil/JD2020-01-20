package by.it.zhuravaskarabahataya.jd01_08;

import java.util.Arrays;

public class Experiments {
    public static void main(String[] args) {
        System.out.println("hello");

        int[] sourceArray2 = {1, 2, 3, 4};
        int[] copiedArray = Arrays.copyOf(sourceArray2, sourceArray2.length);

        print(sourceArray2);
        print(copiedArray);

        for (int i = 0; i < sourceArray2.length; i++) {
            sourceArray2[i] += 1;
        }
        print(sourceArray2);
        print(copiedArray);

        for (int i = 0; i < copiedArray.length; i++) {
            copiedArray[i] +=2;
        }

        print(sourceArray2);
        print(copiedArray);

        int[][] array2d = {{1,2,3}, {4,5,6}};
        int[][] copiedArray2d = Arrays.copyOf(array2d, array2d.length);
        print2d(array2d);
        print2d(copiedArray2d);

        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[0].length; j++) {
                array2d[i][j] += 1;
            }
        }

        print2d(array2d);
        print2d(copiedArray2d);
        int[][] sourceArray = {{1,2,3},{4,5,5}};
        int[][] copied = copy2dArray(sourceArray);
        print2d(copied);
    }

    private static int[][] copy2dArray(int[][] source){
        int[][] resultArray = new int[source.length][source[0].length];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                resultArray[i][j] = source[i][j];
            }
        }
        return resultArray;
    }

    private static void print(int[] arr){
        for (int a:arr
             ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void print2d(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
        System.out.println();
    }
}

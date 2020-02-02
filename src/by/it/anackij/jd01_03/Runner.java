package by.it.anackij.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String sample = "1 0 76 3 12 99 5";
        double[] array = InOut.getArray(sample);
        double[] vactor = {7, 8, 3};
        double[][] firstArray2D = {{1,2,3,4},{5,6,7,8}};
        double[][] secondArray2D = {{4,3,7,4},{12,7,8,10}};
        InOut.printArray(array);
        InOut.printArray(array, "A3", 4);
        InOut.printArray(array, "A4", 3);
        InOut.printArray(array, "A6", 6);

        System.out.println(Helper.findMax(array));
        System.out.println(Helper.findMin(array));
        Helper.sort(array);
        Helper.mul(firstArray2D,vactor);
        Helper.mul(firstArray2D,secondArray2D);
    }
}

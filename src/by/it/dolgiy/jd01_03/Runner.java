package by.it.dolgiy.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        System.out.println("Min = " + Helper.findMin(array));
        System.out.println("Max = " + Helper.findMax(array));
        Helper.sort(array);
        System.out.println();
        double[][] array2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[] array3 = {1, 2, 3};
        System.out.println(Arrays.toString(Helper.mul(array2, array3)));
        System.out.println(Arrays.deepToString(Helper.mul(array2, array2)));
    }
}


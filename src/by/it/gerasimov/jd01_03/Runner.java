package by.it.gerasimov.jd01_03;

import java.util.Arrays;

class Runner {
    public static void main(String[] args) {
        String str = "2.1 23 4 4 2 1";
        double[] array = InOut.getArray(str);
        System.out.println(Arrays.toString(array));
        Helper.sort(array);
        InOut.printArray(array);
        InOut.printArray(array, "m", 3);
    }
}

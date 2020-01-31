package by.it.kondratev.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        //InOut.printArray(array);
        //InOut.printArray(array, "N",3);
        //System.out.println(Helper.findMin(array));
        //System.out.println(Helper.findMax(array));
        //Helper.sort(array);
    }

}

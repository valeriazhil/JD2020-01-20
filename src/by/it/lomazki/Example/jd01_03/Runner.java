package by.it.lomazki.Example.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strArray = scanner.nextLine();
        double[] array = InOut.getArray(strArray);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
    }
}

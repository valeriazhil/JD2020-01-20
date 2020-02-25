package by.it.cherkas.jd01_03;

import java.util.Scanner;

 class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        System.out.println("Минимум массива min=" + Helper.findMin(array));
        System.out.println("Максимум массива max=" + Helper.findMax(array));
        System.out.println("Сортировка: ");
        Helper.sort(array);

    }
}
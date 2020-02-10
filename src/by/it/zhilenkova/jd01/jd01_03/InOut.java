package by.it.zhilenkova.jd01.jd01_03;

import java.util.Scanner;

public class InOut {
    /**
     * Получение массива из строки
     * @param line - строка чисел через пробел
     * @return массив чисел типа double
     */
    public static double[] getArray(String line){
        String[] stringsArr = line.trim().split(" ");
        double[] result = new double[stringsArr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(stringsArr[i]);
        }
        return  result;
    }

    /**
     * Вывод простого массива
     * @param arr - массив чисел типа double
     */
    public static void printArray(double[]arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }

    /**
     * Вывод массива с заданным именем и колличеством колонок
     * @param arr - массив чисел типа double
     * @param name - имя массива
     * @param columnCount - количестово колонок
     */
    public static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f", name, i, arr[i]);
            col++;
            if(col % columnCount == 0 || col == arr.length){
                System.out.println();
            }
        }
    }
}

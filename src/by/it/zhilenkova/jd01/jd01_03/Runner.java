package by.it.zhilenkova.jd01.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {


        // Часть А
        System.out.println("Введите значения массива:");
        double[] array = inputArray();//получение массива чисел
        System.out.println("Простой вывод массива:");
        InOut.printArray(array); //печать массива
        System.out.println();
        System.out.println("Вывод массива с именем количетсовм колонок:");
        InOut.printArray(array, "A", 5); //печать массива с значениями


        // Часть В
        System.out.println("MIN = " + Helper.findMin(array)); // поиск и печать минимума
        System.out.println("MAX = " + Helper.findMax(array)); // поиск и печать максимума
        Helper.sort(array); //сортировка массива по возрастанию
        System.out.println("Sorted Array= " + Arrays.toString(array)); // печать сортированного массива


        //Часть С
        double[][] matrix1 = {
                {3, -1, 2},
                {4, 2, 0},
                {-5, 6, 1}
        };

        double[][] matrix2 = {
                {8, 1},
                {7, 2},
                {2, -3}
        };
        double[] vector = {8, 7, 2};

        double[] multVector = Helper.mul(matrix1, vector); //Умножение матрицы на вектор
        System.out.println("Multipli Vector = " + Arrays.toString(multVector));

        double[][] multMatrix = Helper.mul(matrix1, matrix2); //Умножение матрицы на матрицу
        System.out.println("Multipli Matrix = ");
        for(double[]row : multMatrix){
            System.out.println(Arrays.toString(row));
        }

    }

    private static double[] inputArray(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line); //Преобразование строки в массив
        return array;
    }
}

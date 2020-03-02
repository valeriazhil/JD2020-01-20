package by.it.degtyaryov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        step1(i);

        int[][] mass = new int[][]{
                {1, -2, -2, 6},
                {-1, 2, -2, 2},
                {-2, -2, -6, -2},
                {1, 2, -2, 6}};

        System.out.println(step2(mass));

        System.out.println(Arrays.deepToString(step3(mass)));
    }

    static int[][] step1(int i) {
        int[][] array = new int[i][i];
        do {
            // Уточнить почему идея предлагает убрать "array ="
            fillArrayRandomNumbers(array, -i, i);
        } while (!arrayContains(array, -i, i));
        System.out.println(Arrays.deepToString(array));
        return array;
    }

    static int step2(int[][] mas) {
        ArrayEditor arrayEditor = new ArrayEditor(mas);
        return arrayEditor.getSumBetweenPositiveNumbers();
    }

    static int[][] step3(int[][] mass) {
        ArrayEditor arrayEditor = new ArrayEditor(mass);
        return arrayEditor.deleteLinesWithMaxValue();
    }

    private static int[][] fillArrayRandomNumbers(int[][] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * ((max - min) + 1)) + min;
            }
        }
        return array;
    }

    private static boolean arrayContains(int[][] array, int min, int max) {
        boolean containsMin = false;
        boolean containsMax = false;

        for (int[] i : array) {
            for (int j : i) {
                containsMin = (j == min) || containsMin;
                containsMax = (j == max) || containsMax;
            }
        }
        return containsMin && containsMax;
    }
}

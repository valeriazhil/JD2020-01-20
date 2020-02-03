package by.it.degtyaryov.jd01_02;

import java.util.Set;
import java.util.TreeSet;

public class ArrayEditor {
    private int[][] array;

    private int sumBetweenPositiveNumbers;

    private int maxValue;
    private Set<Integer> columnsWithMaxValue;
    private Set<Integer> rowsWithMaxValue;

    public ArrayEditor(int[][] array) {
        this.array = array;
        columnsWithMaxValue = new TreeSet<>();
        rowsWithMaxValue = new TreeSet<>();
        maxValue = maxValueInArray(array);
        findColumnsAndRowsWithMaxValue();
        sumBetweenDeep();
    }

    private void sumBetweenDeep() {
        for (int[] i : array) {
            if (hasTwoPositive(i)) {
                sumBetweenPositiveNumbers += sumBetween(i);
            }
        }
    }

    private boolean hasTwoPositive(int[] array) {
        int countPossitive = 0;
        for (int i : array) {
            if (i > 0) {
                countPossitive++;
            }
        }
        return countPossitive > 1;
    }

    private int sumBetween(int[] array) {
        int sum = 0;
        // count - это порядковый номер позитивного числа в массиве
        // для отслеживания необходимости суммирования чисел
        int count = 0;
        for (int i : array) {
            if (count == 1) {
                if (i < 0) {
                    sum += i;
                } else {
                    count++;
                }
            } else {
                if (i > 0) {
                    count++;
                }
            }
        }
        return sum;
    }

    public int[][] deleteLinesWithMaxValue() {
        int indexI = 0;
        int indexJ = 0;

        int[][] newArray = new int[array.length - rowsWithMaxValue.size()][array[0].length - columnsWithMaxValue.size()];

        for (int i = 0; i < array.length; i++) {
            if (!rowsWithMaxValue.contains(i)) {
                for (int j = 0; j < array[i].length; j++) {
                    if (!columnsWithMaxValue.contains(j)) {
                        newArray[indexI][indexJ] = array[i][j];
                        indexJ++;
                    }
                }
                indexJ = 0;
                indexI++;
            }
        }
        return newArray;
    }

    private int maxValueInArray(int[][] oldArray) {
        int max = oldArray[0][0];
        for (int[] i : oldArray) {
            for (int j : i) {
                max = Math.max(j, max);
            }
        }
        return max;
    }

    private void findColumnsAndRowsWithMaxValue() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == maxValue) {
                    columnsWithMaxValue.add(j);
                    rowsWithMaxValue.add(i);
                }
            }
        }
    }

    public int getSumBetweenPositiveNumbers() {
        return sumBetweenPositiveNumbers;
    }
}

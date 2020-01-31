package by.it.degtyaryov.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

class TaskC {

    public static void main(String[] args) {
        exerciseSix();
        exerciseSeven();
    }

    private static void exerciseSix() {
        double[] array = randomArray();
        System.out.println("Массив A[]");
        InOut.printArray(array, "A", 5);
        double[] arrayGreater = arrayWithGreaterNums(array, 3.5);
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(arrayGreater, "B", 5);
        System.out.printf("Среднее геометрическое значение = %.3f%n", geometricValue(arrayGreater));
    }

    private static void exerciseSeven() {
        //TODO:сделать метод создающий массив случайных чисел
        double[] arr = randomArray(31, -103, 450);
        InOut.printBorderedArrayHorizontal(arr, "M");
        double[] newArr = arrayWithNumsBiggerIndex(arr);
        Arrays.sort(arr);
        InOut.printBorderedArrayVertical(newArr, "B");
    }

    /**
     * @return массив из 20-40 элементов, заполненных значениями z=(x^2+4.5)^(1/3),
     * где x изменяется от [5.33; 9]
     * @author DEA
     */
    private static double[] randomArray() {
        Random random = new Random();
        int size = random.nextInt(21) + 20;
        double[] array = new double[size];
        double step = (9 - 5.33) / (size - 1);
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            double z = cbrt(pow(x, 2) + 4.5);
            array[i] = z;
            x += step;
        }
        return array;
    }

    /**
     * Создает новый массив содержащий только элементы больше заданного значения из исходного массива
     *
     * @param sourceArray исходный массив
     * @param value       величина, больше которой производится отбор элементов
     * @return массив элементов, больше заданного значения
     * @author DEA
     */
    private static double[] arrayWithGreaterNums(double[] sourceArray, double value) {
        int size = 0;
        for (double element : sourceArray) {
            if (element > value) {
                size++;
            }
        }
        int index = 0;
        double[] newArray = new double[size];
        for (double element : sourceArray) {
            if (element > value) {
                newArray[index++] = element;
            }
        }
        return newArray;
    }

    /**
     * Расчет среднего геометрического значения элементов массива
     *
     * @param array массив для поиска среднего геометрического
     * @return среднее геометрическое значение
     * @author DEA
     */
    private static double geometricValue(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double multiply = 1;
        for (double element : array) {
            multiply *= element;
        }
        return pow(multiply, 1.0 / array.length);
    }

    /**
     * @param size количество элементов в новом массиве
     * @param min  минимальное значение элемента
     * @param max  максимальное значение элемента
     * @return массив содержащий size элементов, заполненный случайными значениями от min значения до max
     * @author DEA
     */
    private static double[] randomArray(int size, int min, int max) {
        double[] array = new double[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble() * (max - min) + min;
        }
        return array;
    }

    /**
     * Создает новый массив содержащий только элементы, у которых 10% значения больше индекса в исходном массиве
     *
     * @param sourceArray исходный массив
     * @return массив элементов, у которых 10% значения больше индекса в исходном массиве
     * @author DEA
     */
    private static double[] arrayWithNumsBiggerIndex(double[] sourceArray) {
        int size = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] * 0.1 > i) {
                size++;
            }
        }
        int index = 0;
        double[] newArray = new double[size];
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] * 0.1 > i) {
                newArray[index++] = sourceArray[i];
            }
        }
        return newArray;
    }
}

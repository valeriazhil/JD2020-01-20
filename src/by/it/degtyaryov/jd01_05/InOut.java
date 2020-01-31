package by.it.degtyaryov.jd01_05;

import static java.lang.Math.*;

/**
 * Класс для ввода-вывода массивов
 *
 * @author DEA
 */
class InOut {

    /**
     * Выводит в консоль значения массива в заданном формате
     *
     * @param array       одномерный массив типа double
     * @param arrayName   имя массива
     * @param columnCount количество столбцов для вывода
     * @author DEA
     */
    static void printArray(double[] array, String arrayName, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d] = %-8.5f", arrayName, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Выводит в консоль массив в виде таблицы с границами, где элементы расположены горизонтально
     *
     * @param array     массив для вывода
     * @param arrayName имя массива
     * @author DEA
     */
    static void printBorderedArrayHorizontal(double[] array, String arrayName) {
        System.out.printf("Массив %s <index to rows>%n", arrayName);
        if (array.length == 0) {
            System.out.printf("Массив %s не содержит элементов", arrayName);
            return;
        }
        // поиск длины максимального элемента массива, для последующего задания ширины ячейки
        int lengthOfMaxElement = String.valueOf((int) findAbsMax(array)).length();
        // формат в которм будет отображаться содержимое ячейки
        String pattern = "%2s[% -3d]=%-" + (lengthOfMaxElement + 4) + ".2f ";
        // количество колонок в таблице. Если длина массива < 5, то количество колонок = длине, иначе = 5
        int columns = min(array.length, 5);
        int rows = (int) ceil(array.length / 5.0);
        int elementWidth = String.format(pattern, arrayName, 0, array[0]).length();

        printFirstLine(columns, elementWidth);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = (i * 5) + j;
                if (j == 0) {
                    System.out.print("\u2551");
                }
                if (index < array.length) {
                    printElement(pattern, arrayName, index, array[index]);
                } else {
                    printEmptyElement(elementWidth);
                }
                System.out.print("\u2551");
            }
            System.out.println();
            if (i != rows - 1) {
                printSeparator(columns, elementWidth);
            }
        }
        printLastLine(columns, elementWidth);
    }

    /**
     * Выводит в консоль массив в виде таблицы с границами, где элементы расположены вертикально
     *
     * @param array     массив для вывода
     * @param arrayName имя массива
     * @author DEA
     */
    static void printBorderedArrayVertical(double[] array, String arrayName) {
        System.out.printf("Массив %s <index to columns>%n", arrayName);
        if (array.length == 0) {
            System.out.printf("Массив %s не содержит элементов", arrayName);
            return;
        }
        // поиск длины максимального элемента массива, для последующего задания ширины ячейки
        int lengthOfMaxElement = String.valueOf((int) findAbsMax(array)).length();
        // формат в которм будет отображаться содержимое ячейки
        String pattern = "%2s[% -3d]=%-" + (lengthOfMaxElement + 3) + ".2f ";
        // количество колонок в таблице. Если длина массива < 5, то количество колонок = длине, иначе = 5
        int columns = (int) ceil(array.length / 5.0);
        int rows = min(array.length, 5);
        int elementWidth = String.format(pattern, arrayName, 0, array[0]).length();

        printFirstLine(columns, elementWidth);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = (j * 5 + i);
                if (j == 0) {
                    System.out.print("\u2551");
                }
                if (index < array.length) {
                    printElement(pattern, arrayName, index, array[j * 5 + i]);
                } else {
                    printEmptyElement(elementWidth);
                }
                System.out.print("\u2551");
            }
            System.out.println();
            if (i != rows - 1) {
                printSeparator(columns, elementWidth);
            }
        }
        printLastLine(columns, elementWidth);
    }

    /**
     * Вывод пустой ячейки в таблице
     *
     * @param elementWidth ширина одного элемента (колонки)
     * @author DEA
     */
    private static void printEmptyElement(int elementWidth) {
        for (int i = 0; i < elementWidth; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Вывод элемента массива в заданном формате
     *
     * @param pattern     формат вывода
     * @param arrayName   имя массива
     * @param index       индекс элемента
     * @param lementValue значение элемента
     */
    private static void printElement(String pattern, String arrayName, int index, double lementValue) {
        System.out.printf(pattern, arrayName, index, lementValue);
    }

    /**
     * Вывод верхней границы таблицы
     *
     * @param columns      количество колонок в таблице
     * @param elementWidth ширина одного элемента (колонки)
     */
    private static void printFirstLine(int columns, int elementWidth) {
        System.out.print("\u2554");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < elementWidth; j++) {
                System.out.print("\u2550");
            }
            if (i != columns - 1) {
                System.out.print("\u2566");
            }
        }
        System.out.print("\u2557\n");
    }

    /**
     * Вывод верхней границы таблицы
     *
     * @param columns      количество колонок в таблице
     * @param elementWidth ширина одного элемента (колонки)
     */
    private static void printLastLine(int columns, int elementWidth) {
        System.out.print("\u255A");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < elementWidth; j++) {
                System.out.print("\u2550");
            }
            if (i != columns - 1) {
                System.out.print("\u2569");
            }
        }
        System.out.print("\u255D\n");
    }

    /**
     * Вывод линии, разделяющей строки таблицы
     *
     * @param columns      количество колонок в таблице
     * @param elementWidth ширина одного элемента (колонки)
     */
    private static void printSeparator(int columns, int elementWidth) {
        System.out.print("\u2560");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < elementWidth; j++) {
                System.out.print("\u2550");
            }
            if (i != columns - 1) {
                System.out.print("\u256C");
            }
        }
        System.out.print("\u2563\n");
    }

    /**
     * Поиск максимального абсолютного значения (по модую) для нахождения максимальной ширины ячейки
     *
     * @param array массив для поиска
     * @return максимальное абсолютное значение массива (по модую)
     */
    private static double findAbsMax(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double max = array[0];
        for (double elem : array) {
            max = max(max, abs(elem));
        }
        return max;
    }
}
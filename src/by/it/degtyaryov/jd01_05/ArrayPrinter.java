package by.it.degtyaryov.jd01_05;

import static java.lang.Math.*;

class ArrayPrinter {

    private double[] array;
    private boolean isHorizontal;
    private String arrayName;
    private int columns;
    private int rows;
    private int elementWidth;
    private String pattern;

    public ArrayPrinter(double[] array, String arrayName, boolean isHorizontal) {
        this.array = array;
        this.isHorizontal = isHorizontal;
        this.arrayName = arrayName;
        if (isHorizontal) {
            columns = min(array.length, 5);
            rows = (int) ceil(array.length / 5.0);
        } else {
            columns = (int) ceil(array.length / 5.0);
            rows = min(array.length, 5);
        }
        int maxElementLength = String.valueOf((int) findAbsMax(array)).length();
        pattern = "%2s[% -3d]=%-" + (maxElementLength + 4) + ".2f ";
        this.elementWidth = (array.length == 0) ? 0 : String.format(pattern, arrayName, 0, array[0]).length();
    }

    /**
     * Выводит в консоль массив в виде таблицы с границами
     *
     * @author DEA
     */
    public void printBorderedArray() {
        System.out.printf("Массив %s <index to rows>%n", arrayName);
        if (array.length == 0) {
            System.out.printf("Массив %s не содержит элементов%n", arrayName);
            return;
        }
        printFirstLine();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = (isHorizontal) ? (i * 5) + j : (j * 5) + i;
                if (j == 0) {
                    System.out.print("\u2551");
                }
                if (index < array.length) {
                    printElement(index);
                } else {
                    printEmptyElement();
                }
                System.out.print("\u2551");
            }
            System.out.println();
            if (i != rows - 1) {
                printSeparator();
            }
        }
        printLastLine();
    }

    /**
     * Вывод элемента массива по индексу в заданном формате
     *
     * @param index индекс элемента
     * @author DEA
     */
    private void printElement(int index) {
        System.out.printf(pattern, arrayName, index, array[index]);
    }

    /**
     * Вывод пустой ячейки в таблице
     *
     * @author DEA
     */
    private void printEmptyElement() {
        for (int i = 0; i < elementWidth; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Вывод ыерхней границы таблицы
     *
     * @author DEA
     */
    private void printFirstLine() {
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
     * Вывод нижней границы таблицы
     *
     * @author DEA
     */
    private void printLastLine() {
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
     * @author DEA
     */
    private void printSeparator() {
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
     * @author DEA
     */
    private double findAbsMax(double[] array) {
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

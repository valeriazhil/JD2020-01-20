package by.it.degtyaryov.jd01_05;

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

    static void printBorderedArrayHorizontal(double[] array, String arrayName) {
        if(array.length==0){
            System.out.printf("Массив %s не содержит элементов", arrayName);
            return;
        }
        // поиск длины максимального элемента массива, для последующего задания ширины ячейки
        int lengthOfMaxElement = String.valueOf((int) findMax(array)).length();
        // формат в которм будет отображаться содержимое ячейки
        String pattern = "%2s[% -3d]=%-" + (lengthOfMaxElement + 4) + ".2f ";
        // количество колонок в таблице. Если длина массива < 5, то количество колонок = длине, иначе = 5
        int columns = Math.min(array.length, 5);
        int rows = (int) Math.ceil(array.length / 5.0);
        int elementWidth = String.format(pattern, arrayName, 0, array[0]).length();
        int index = 0;

        printFirstLine(columns, elementWidth);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    System.out.print("\u2551");
                }
                if (index < array.length) {
                    printElement(pattern, arrayName, index, array[index++]);
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

    static void printBorderedArrayVertical(double[] array, String arrayName) {
        if(array.length==0){
            System.out.printf("Массив %s не содержит элементов", arrayName);
            return;
        }
        // поиск длины максимального элемента массива, для последующего задания ширины ячейки
        int lengthOfMaxElement = String.valueOf((int) findMax(array)).length();
        // формат в которм будет отображаться содержимое ячейки
        String pattern = "%2s[% -3d]=%-" + (lengthOfMaxElement + 3) + ".2f ";
        // количество колонок в таблице. Если длина массива < 5, то количество колонок = длине, иначе = 5
        int columns = (int) Math.ceil(array.length / 5.0);
        int rows = Math.min(array.length, 5);
        int elementWidth = String.format(pattern, arrayName, 0, array[0]).length();
        int index = 0;



        printFirstLine(columns, elementWidth);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    System.out.print("\u2551");
                }
                if (index < array.length) {
                    printElement(pattern, arrayName, (j*5+i), array[j*5+i]);
                    index++;
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

    private static void printEmptyElement(int elementWidth) {
        for (int i = 0; i < elementWidth; i++) {
            System.out.print(" ");
        }
    }

    private static void printElement(String pattern, String arrayName, int index, double element) {
        System.out.printf(pattern, arrayName, index, element);
    }

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

    private static void printLastLine(int countElement, int elementWidth) {
        System.out.print("\u255A");
        for (int i = 0; i < countElement; i++) {
            for (int j = 0; j < elementWidth; j++) {
                System.out.print("\u2550");
            }
            if (i != countElement - 1) {
                System.out.print("\u2569");
            }
        }
        System.out.print("\u255D\n");
    }

    private static void printSeparator(int countElement, int elementWidth) {
        System.out.print("\u2560");
        for (int i = 0; i < countElement; i++) {
            for (int j = 0; j < elementWidth; j++) {
                System.out.print("\u2550");
            }
            if (i != countElement - 1) {
                System.out.print("\u256C");
            }
        }
        System.out.print("\u2563\n");
    }

    private static double findMax(double[] array) {
        if(array.length == 0) {
            return 0;
        }
        double max = array[0];
        for (double elem : array) {
            max = Math.max(max, Math.abs(elem));
        }
        return max;
    }
}
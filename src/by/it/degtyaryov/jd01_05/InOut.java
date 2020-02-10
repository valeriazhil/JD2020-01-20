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
}
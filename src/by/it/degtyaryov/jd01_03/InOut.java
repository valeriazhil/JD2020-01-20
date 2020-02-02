package by.it.degtyaryov.jd01_03;

/**
 * Класс для ввода-вывода массивов
 *
 * @author DEA
 */
class InOut {

    /**
     * Возвращает массив чисел из строки
     *
     * @param line строка, содержащая числа типа double, разделенные пробелом
     * @return массив чисел типа double
     * @author DEA
     */
    static double[] getArray(String line) {
        String[] strArray = line.trim().split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    /**
     * Выводит в консоль значения массива через пробел
     *
     * @param array одномерный массив типа double
     * @author DEA
     */
    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

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
            System.out.printf("%s[% -3d]=%-8.4f ", arrayName, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

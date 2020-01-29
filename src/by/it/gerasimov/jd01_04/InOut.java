package by.it.gerasimov.jd01_04;

/**
 * Ввод-вывод
 */
class InOut {
    /**
     * Получение массива чисел из строки
     * @param line исходня строка
     * @return массив чисел
     */
    static double[] getArray(String line) {
        String[] s = line.trim().split(" ");
        double[] arr = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Double.parseDouble(s[i]);
        }
        return arr;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int colCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%.1f ", name, i, arr[i]);
            if (((i + 1) % colCount == 0 && i != 0) || i == arr.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

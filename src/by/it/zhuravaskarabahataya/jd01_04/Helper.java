package by.it.zhuravaskarabahataya.jd01_04;

public class Helper {
    /**
     * Сортирует массив по возрастанию
     *
     * @param arr массив типа double
     */
    static void sort(double[] arr) {
        boolean swap = false;
        do {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }

        }
        while (swap);
    }
}

package by.it.anackij.jd01_04;

class InOut {

    static double[] getArray(String line) {
        //1 2 3 66 88 99 0
        String[] strArray = line.trim().split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);//valueOf возвращает в оболочке, после надо распоковывать
        }

        return array;


    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1)
                System.out.println();
        }
    }
}

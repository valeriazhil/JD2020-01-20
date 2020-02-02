package by.it.lomazki.Example.jd01_04;

public class InOut {
    static double[ ] getArray(String line) {
        String [] strArray = line.split(" ");
        double [] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static void printArray(double[ ] arr) {
        for (double element : arr) {
            System.out.println(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            // V[1]=12.3456
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i+1)%columnCount == 0 || i+1==arr.length)
                System.out.println();
        }
    }
}

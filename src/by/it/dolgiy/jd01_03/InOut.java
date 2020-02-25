package by.it.dolgiy.jd01_03;

class InOut {

    static double[] getArray(String line){
        String[] string1 = line.split(" ");
        double[] mas = new double[string1.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(string1[i]);
        }
        return mas;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f", name, i, arr[i]);
            if ((i+1)%columnCount==0 || (i+1)==arr.length){
                System.out.println();
            }
        }
    }
}

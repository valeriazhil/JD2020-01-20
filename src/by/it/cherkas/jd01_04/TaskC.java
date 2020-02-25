package by.it.cherkas.jd01_04;

import java.util.Scanner;

 class TaskC {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        buildOneDimArray(str);
    }


    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        //Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == stop) {
                System.out.println("Index of last element=" + i);
                break;
            }


        }
    }

 /*  static void mergeSort(double[ ] array){
        if (array == 0){
            System.out.println("Массив пуст");
        }
        if (array.length<2){

        }
   //     double arrayA = new double[array]
   }
  //  private static void mergeSort(double[ ] array, int left, int right);*/
}
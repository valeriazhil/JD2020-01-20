package by.it.makarenko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printMulTable();
        buildOneDimArray(str);
    }
    static void printMulTable(){
        for (int i = 2; i <=9 ; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] arrays = InOut.getArray(line);
        double min = arrays[0];
        double max = arrays[arrays.length-1];
        InOut.printArray(arrays,"V", 5);
        Arrays.sort(arrays);
        InOut.printArray(arrays,"V", 4);


        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i]==min){
                System.out.println("Index of first element="+i);
                break;
            }

        }
        for (int i = 0; i <arrays.length-1 ; i++) {
            if (arrays[i]==max){
                System.out.println("Index of last element="+i);
                break;
            }
        }

    }

}

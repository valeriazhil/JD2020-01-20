package by.it.kondratev.jd01_04;

import by.it.kondratev.jd01_03.Helper;
import by.it.kondratev.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    public static void main(String[ ] args){
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.nextLine();
        //String  string = "123 99 88 77 66 5 4 3 1 0 2";
        buildOneDimArray(str);

    }

    static void printMulTable(){
        String [][] elem = new String[8][8];
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,i*j);  }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        line = line.trim();                                //скопировано из InOut ...
        String[] strArr = line.split(" ");
        int count = strArr.length;
        double[] mas = new double[count];
        for (int i = 0; i < count; i++) {
            mas[i] = Double.parseDouble(strArr[i]);        //... скопировано из InOut
        }

        InOut.printArray(mas,"V",5);
        double first = mas[0]; double last = mas[count-1];
        Helper.sort(mas);
        System.out.println();
        InOut.printArray(mas,"V",4);
        for (int i = 0; i < count; i++) {
            if (first == mas[i]) System.out.println("Index of first element="+i);
            if(last==mas[i]) System.out.println("Index of last element="+i);
        }

    }
}

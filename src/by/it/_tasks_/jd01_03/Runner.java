package by.it._tasks_.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        //1 2 3 5 19 20 14 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double [] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double [][] array2 =   {{1,2,3,4},
                                {11,12,13,14},
                                {21,22,23,24}};
        double [][] array3 = {{1,2,3},{12,11,13},{21,22,23}};
        Helper.mul(array2,array);
        Helper.mul(array2,array3);

    }
}

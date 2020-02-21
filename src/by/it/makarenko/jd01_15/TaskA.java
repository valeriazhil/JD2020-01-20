package by.it.makarenko.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;

public class TaskA {
    private static final Random RND = new Random();

    public static void main(String[] args) {
        int[][] matrix = generate(6,4);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static int[][] generate(int rows, int cols) {
        int [][] result = new int [rows][cols];
        boolean maxOk = false;
        boolean minOk = false;
        do {
            maxOk = false;
            minOk = false;
            for (int[] row : result) {
                for (int i = 0; i <row.length ; i++) {
                    row[i]=RND.nextInt(31)-15;
                    if (row[i]==15)maxOk=true;
                    if (row[i]==-15)minOk=true;
                }
            }
        } while(!maxOk||!minOk);
    return result;
    }
}

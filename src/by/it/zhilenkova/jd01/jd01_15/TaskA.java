package by.it.zhilenkova.jd01.jd01_15;


import java.io.*;
import java.util.Random;

class TaskA {

    private static final Random random = new Random();
    private static String fileName = Helper.getPath( "matrix.txt", TaskA.class);

    public static void main(String[] args) {
        int [][] matrix = createMatrix (6,4);
        printMatrix(matrix);
        matrixToFile(matrix);
        System.out.println();
        readFileToConsole(fileName);
    }

    private static void readFileToConsole(String fileName) {
        try (FileReader fr = new FileReader(fileName))
        {
        while (fr.ready()) {
            int data = fr.read();
            System.out.printf("%c",(char) data);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void matrixToFile(int[][] matrix) {
        File file = new File(fileName);
        try (PrintWriter pw = new PrintWriter(file)){
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    pw.printf("%3d ", ints[j]);
                }
                pw.printf("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }


    private static int[][] createMatrix(int rows, int cols) {
        boolean max = false;
        boolean min = false;
        int[][] result = new int[rows][cols];
        while (!max || !min) {
            max = false;
            min = false;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    int rand = random.nextInt(31) - 15;
                    if (rand == 15){
                        max = true;
                    }
                    else if(rand == -15){
                        min = true;
                    }
                    result[i][j] = rand;
                }
            }
        }
        return result;
    }

}

package by.it.dolgiy.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class TaskA {

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        String fileName = TaskH.getPath(TaskA.class,"matrix.txt");
        int[][] matrix = matrix(6,4);
        writeMatrix(fileName, matrix);
        matrix = readMatrix(fileName);
        for (int[] rows : matrix) {
            for (int cols : rows) {
                System.out.printf("%3d ", cols);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(String fileName) {
        int[][] array=new int[0][0];
        ArrayList<String> list = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while ((line = reader.readLine())!=null) {
                list.add(line);
            }
            array = new int[list.size()][0];
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                String[] m = s.trim().split("\\s+");
                array[i] = new int[m.length];
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.parseInt(m[j]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error:"+e);
        }
        return array;
    }

    private static void writeMatrix(String fileName, int[][] matrix) {
        try (PrintWriter printWriter = new PrintWriter(fileName)){
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error:"+e);
        }
    }

    private static int[][] matrix(int rows, int cols) {
        int[][] res = new int[rows][cols];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int[] row : res) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = rnd.nextInt(31) - 15;
                    if (row[i] == 15) maxOk = true;
                    if (row[i] == -15) minOk = true;
                }
            }
        } while (!maxOk || !minOk);
        return res;
    }

}

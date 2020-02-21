package by.it.makarenko.jd01_15;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TaskA {
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        String fileName = Helper.getPath(TaskA.class, "matrix.txt");
        int[][] array = generate(6, 4);
        System.out.println(Arrays.deepToString(array));
        saveArray(array, fileName);
        array = loadArray(fileName);
        System.out.println(Arrays.deepToString(array));

    }

    private static int[][] generate(int rows, int cols) {
        int[][] result = new int[rows][cols];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int[] row : result) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = rnd.nextInt(31) - 15;
                    if (row[i] == 15) maxOk = true;
                    if (row[i] == -15) minOk = true;
                }
            }
        } while (!maxOk || !minOk);
        return result;
    }

    private static int[][] loadArray(String fileName) {
        int[][] array = new int[0][0];
        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))
        ) {
            ArrayList<String> list = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                list.add(line);
            }
            array = new int[list.size()][0];
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                String[] m = s.trim().replace(",","").split("\\s+");
                array[i] = new int[m.length];
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.parseInt(m[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static void saveArray(int[][] array, String fileName) {
        try {
            try (
                    PrintWriter printWriter = new PrintWriter(fileName)) {
                for (int[] row : array) {
                    for (int e : row) {
                        printWriter.printf("%3d ",e);
                    }
                    printWriter.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
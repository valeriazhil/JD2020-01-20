package by.it.degtyaryov.jd01_15;

import java.io.*;
import java.util.Random;

class TaskA {

    private static final String FILE_PATH = Helper.getPath(TaskA.class, "matrix.txt");
    private static final int MIN_VALUE = -15;
    private static final int MAX_VALUE = 15;

    public static void main(String[] args) {
        int[][] array = generateArray(6, 4);
        saveArray(array);
        loadFile(FILE_PATH);
    }

    private static void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveArray(int[][] array) {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            for (int[] row : array) {
                for (int num : row) {
                    writer.printf("%3d ", num);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[][] generateArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        Random random = new Random();
        boolean hasMin;
        boolean hasMax;
        do {
            hasMin = false;
            hasMax = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = random.nextInt(31) - 15;
                    if (array[i][j] == MIN_VALUE) hasMin = true;
                    if (array[i][j] == MAX_VALUE) hasMax = true;
                }
            }
        } while (!hasMin || !hasMax);
        return array;
    }
}

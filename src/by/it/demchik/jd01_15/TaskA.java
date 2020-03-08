package by.it.demchik.jd01_15;

//Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
// Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
// При выводе для
//каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
// Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.


//Что тут произошло?

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

class TaskA {

    private static final Random random = new Random();
    private static String fileName = Helper.getPath("matrix.txt", TaskA.class);

    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4);
        printMatrix(matrix);
        matrixToFile(matrix);
        System.out.println();
        readFileToConsole(fileName);
    }

    private static void readFileToConsole(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            while (fr.ready()) {
                int data = fr.read();
                System.out.printf("%c", (char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void matrixToFile(int[][] matrix) {
        File file = new File(fileName);
        try (PrintWriter pw = new PrintWriter(file)) {
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
                    if (rand == 15) {
                        max = true;
                    } else if (rand == -15) {
                        min = true;
                    }
                    result[i][j] = rand;
                }
            }
        }
        return result;
    }
}
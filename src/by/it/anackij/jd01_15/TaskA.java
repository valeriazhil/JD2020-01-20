package by.it.anackij.jd01_15;

//Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
// Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
// При выводе для
//каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
// Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.


//Что тут произошло?

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

//    public static void main(String[] args) {
//        int [][] matrix = generateMatrix (6,4);
//        String file = Helper.getPath("matrix.txt");
//        System.out.println();
//        try (PrintWriter printWriter = new PrintWriter(file))
//        {
//            for (int[] rows : matrix) {
//                for (int row : rows) {
//                    printWriter.printf("%3d", row);
//                }
//                printWriter.println();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        loadArray(file);
//
//
//    }
//
//    private static int[][] loadArray(String file) {
//        int[][] matrix;
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            ArrayList<String> list = new ArrayList<>();
//            while (true){
//                String s = br.readLine();
//                if (s == null){
//                    break;
//                }
//                else {
//                    list.add(s);
//                }
//
//            }
//            matrix = new int[list.size()][0];
//            for (int i = 0; i < list.size(); i++) {
//                String s = list.get(i);
//                String[] arr = s.trim().split("\\s+";
//                matrix[i] = new int[arr.length];
//                for (int j = 0; j < matrix[i].length; j++) {
//                    matrix[i][j] = Integer.parseInt(arr[j]);
//                }
//
//            }
//           return matrix;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
}

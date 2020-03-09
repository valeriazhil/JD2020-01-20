package by.it.kondratev.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        int [][] matrix = create_matrix();
        String file_name = print_to_file(matrix);
        read_from_file(file_name);

    }

    private static void read_from_file(String file_name) {
        int x;
        try (BufferedReader br = new BufferedReader(
                new FileReader(file_name)
        )) {
            x = br.read();
            while (x!=-1) {
                System.out.print((char)x);
                System.out.println(br.readLine());
                x = br.read();
            }

            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String print_to_file(int[][] matrix) {
        String file_name = getPath();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]>-10) {
                    sb.append(' ');
                    if (matrix[i][j]<10 && matrix[i][j]>-1) sb.append(' ');
                }
                sb.append(matrix[i][j]).append(' ');
            }
            if (i< matrix.length-1) sb.append('\n');
        }
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(file_name)
        )) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file_name;

    }

    private static int[][] create_matrix() {
        int[][] array = new int[6][4];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = random.nextInt(31)-15;
            }
        }
        return array;
    }

    static String getPath() {
            String root = System.getProperty("user.dir");
            String name = TaskA.class.getName();
            name = name.replace('.', File.separatorChar).
                    replace(TaskA.class.getSimpleName(),"");
            return root + File.separatorChar + "src" + File.separatorChar + name + "matrix.txt";
        }


}

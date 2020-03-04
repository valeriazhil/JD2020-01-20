package by.it.lomazki.Example;

public class Example {
    public static void main(String[] args) {
        int[][] m = new int[5][5];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 1;
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}

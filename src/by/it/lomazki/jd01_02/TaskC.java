package by.it.lomazki.jd01_02;


public class TaskC {

    static int [][] step3 (int[][] array) {
        // findMax
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max)
                    max = element;
            }
        }
        // getResultArray
        boolean[] delRows = new boolean[array.length];
        boolean[] delCols = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max == array[i][j]) {
                    delRows[i] = true;
                    delCols[j] = true;
                }
            }
        }
        int rows = 0;
        for (boolean element : delRows) if (!element) rows++;
        int cols = 0;
        for (boolean element : delCols) if (!element) cols++;

        int [][] res = new int[rows][cols];

        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRows[i]) {
                int jr = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCols[j]) {
                        res [ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        return res;
    }
}

package by.it.kondratev.jd01_05;

public class TaskC_7 {

    public static void main(String[] args) {
        int[] A = array(31);                              // получаем массив
        int cols = (int)(Math.random()*4+2);                 // число колонок
        System.out.println("Massiv A");
        begin_end(cols, 1);                              // верхняя граница таблицы
        values(A, cols);                                    // строки таблицы
        begin_end(cols, 2);                              // нижняя граница таблицы
        System.out.println("Massiv B");
        array2(A);
    }

    public static void begin_end(int columns, int z) {
        if (z == 1) {
            System.out.print("╔");
            for (int i = 1; i <= columns - 1; i++) {
                System.out.print("═════════╦");
            }
            System.out.println("═════════╗");

        } else {
            System.out.print("╚");
            for (int i = 1; i <= columns - 1; i++) {
                System.out.print("═════════╩");
            }
            System.out.println("═════════╝");
        }
    }

    public static void border(int columns) {
        System.out.print("╠");
        for (int i = 1; i <= columns - 1; i++) {
            System.out.print("═════════╬");
        }
        System.out.println("═════════╣");
    }

    private static int[] array(int n) {
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) mas[i] = (int) (Math.random() * 347 + 104);
        return mas;
    }

    public static void values(int[] mas, int columns) {
        int i = 0;
        for (i = 0; i < mas.length; i++) {
            System.out.printf("║A[%2d]=%3d", i + 1, mas[i]);
            if ((i + 1) % columns == 0) {
                System.out.println("║");
                if (i != mas.length - 1) border(columns);
            } else if (i == mas.length - 1) {
                int k = columns - mas.length % columns;
                for (int j = 1; j <= k; j++) System.out.print("║         ");
                System.out.println("║");
            }
        }

    }

    private static void array2(int[] mas) {
        int y = 0;
        for (int i = 0; i < mas.length; i++) {           // заполняем массив В
            if ((mas[i] / 10) > i + 1) y++;
        }
        int[] mas2 = new int[y];
        int x = 0;
        for (int i = 0; i < mas.length; i++) {
            if ((mas[i] / 10) > i + 1) {
                mas2[x] = mas[i];
                x++;
            }
        }

        for (int i = 0; i < mas2.length - 1; i++) {        // сортировка массива В
            int min = mas2[i];
            for (int j = i + 1; j < mas2.length; j++)
                if (mas2[j] < mas2[i]) {
                    min = mas2[j];
                    mas2[j] = mas2[i];
                    mas2[i] = min;
                }
        }

        int C = (int) (Math.random()*4+2);  double c= (double) C;   // число колонок
        int r = (int) Math.ceil(mas2.length / c);                 // число строк
        begin_end((int)c, 1);
        for (int i = 0; i < r; i++) {
            System.out.print("║");
            for (int j = 0; j < c; j++) {
                if ((i + j * r) <= mas2.length-1)
                    System.out.printf("B[%2d]=%3d║", i + j * r+1, mas2[i + j * r]);
                else System.out.print("         ║");
                if (j==c-1)  {
                    System.out.println();
                    if (i+1<r)  border((int) c);
                    else  begin_end((int)c, 2);}

            }
        }

    }

}








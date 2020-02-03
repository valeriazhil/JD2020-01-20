package by.it.gerasimov.jd01_05;

public class TaskC {

    static void printArray(double[] arr, String name, int colCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%02d]=%g ", name, i, arr[i]);
            if (((i + 1) % colCount == 0 && i != 0) || i == arr.length - 1) {
                System.out.println();
            }
        }
    }

    static void step6() {
        int n = (int) (Math.random() * 21) + 20;
        double[] array = new double[n];
        double dx = (9 - 5.33) / n;
        double x = 5.33;
        for (int i = 0; i < n; i++) {
            array[i] = Math.pow(x * x + 4.5, 1.0 / 3);
            x += dx;
        }
        printArray(array, "Z", 5);
        int newCount = 0;
        for (double v : array) {
            if (v > 3.5) {
                newCount++;
            }
        }
        double[] newArray = new double[newCount];
        int i = 0;
        double mul = 1;
        for (double v : array) {
            if (v > 3.5) {
                newArray[i] = v;
                mul *= v;
                i++;
            }
        }
        printArray(newArray, "N", 4);
        double avg = Math.pow(mul, 1.0 / newArray.length);
        System.out.printf("Ср. геометрическое: %g\n", avg);
    }

    static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        while (left < right) {
            int m = partition(array, left, right);
            quickSort(array, left, m - 1);
            left = m + 1;
        }
    }

    private static int partition(int[] array, int left, int right) {
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= array[left]) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int getIndex(int colCount, int rowCount, int i, int j, boolean toCols) {
        int index = 0;
        if (!toCols) {
            index = (i - 1) * colCount / 2 + j;
        } else {
            index = j * rowCount + (i - 1) / 2;
        }
        return index;
    }

    static void printToCell(int[] array, String name, int colCount, boolean toCols) {
        System.out.println("Massiv " + name + " (index to " + (toCols ? "cols" : "rows") + ")");
        int rowCount = (int) Math.ceil((double) array.length / colCount);
        for (int i = 0; i < rowCount * 2 + 1; i++) {
            if (i == 0) {
                System.out.print("╔");
            } else if (i == rowCount * 2) {
                System.out.print("╚");
            } else if (i % 2 == 0) {
                System.out.print("╠");
            } else {
                System.out.print("║");
            }
            for (int j = 0; j < colCount; j++) {
                if (i % 2 != 0) {
                    int index = getIndex(colCount, rowCount, i, j, toCols);
                    if (index < array.length) {
                        System.out.printf(" %s[%2d]=%-3d ", name, index + 1, array[index]);
                    } else {
                        System.out.print("           ");
                    }
                    System.out.print("║");
                } else {
                    System.out.print("═══════════");
                    if (j < colCount - 1) {
                        if (i == 0) {
                            System.out.print("╦");
                        } else if (i == rowCount * 2) {
                            System.out.print("╩");
                        } else {
                            System.out.print("╬");
                        }
                    }
                }
            }
            if (i == 0) {
                System.out.println("╗");
            } else if (i == rowCount * 2) {
                System.out.println("╝");
            } else if (i % 2 == 0) {
                System.out.println("╣");
            } else {
                System.out.println();
            }
        }
    }

    static void step7() {
        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 348) + 103;
        }
        printToCell(array, "M", 5, false);
        int newCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                newCount++;
            }
        }
        int j = 0;
        int[] newArray = new int[newCount];
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                newArray[j] = array[i];
                j++;
            }
        }
        quickSort(newArray);
        printToCell(newArray, "B", 2, true);
    }

    public static void main(String[] args) {
        step6();
        step7();
    }
}

package by.it.anackij.jd01_04;

public class TaskC {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
        double[] array = {45,23,12,67,45,23,12,1,4};
        mergeSort(array);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        System.out.println();
//        Arrays.binarySearch();

        Helper.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) first = i;
            if (array[i] == last) last = i;
        }
        InOut.printArray(array, "V", 4);
        System.out.printf("%s=%1.0f", "Index of first element", first);
        System.out.println();
        System.out.printf("%s=%1.0f", "Index of last element", last);

    }

    static double[] buildArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        System.out.println();
        return array;
    }

    static void mergeSort(double[] array) {
        int logo = (int) (Math.log(array.length) / Math.log(2.0));
        int[] indexAr = new int[logo+1];
        int left = 0;
        int right = array.length - 1;
        int medium = 1;
        for (int i = 0; i < logo+1; i++) {
            medium = (left + right) / 2;
            indexAr[i] = medium;
            System.out.printf("%s%d/%s%d/%s%d%n", "left= ", left, "medium= ", medium, "right= ", right);
            right = medium;
        }
        mergeArray(array,indexAr);
        for (int element : indexAr) {
            System.out.printf("indexAr[]=%d ",element);
        }
    }

    private static void mergeArray(double[] array, int[] indexAr) {
        int left;
        int right;
        int medium;
        for (int i = 0; i < indexAr.length; i++) {
//            while (){
//                if (array[indexAr[i]]<)
//                array[i]= array[indexAr[i]];
            }
        }
    }



package by.it.akhmelev.jd01_03;


public class Runner {

    public static void main(String[] args) {
        String sample="1 2 3 66 88 99 0";
        double[] array = InOut.getArray(sample);
        InOut.printArray(array);

        int columnCount=4;
        String name="V";

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-8.4f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }


        double[][] matrix={
                {1,2,3,4},
                {1,20,3,4},
                {10,2,30,4},
                {1,2,34,4},
        };


        double[] vector={1,2,3,4};

        double[] result = Helper.mul(matrix, vector);



    }



}

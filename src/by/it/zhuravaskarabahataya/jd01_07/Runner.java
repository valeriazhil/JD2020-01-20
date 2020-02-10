package by.it.zhuravaskarabahataya.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(2);
        System.out.println(scalar1);
        Var scalar2 = new Scalar("13");
        System.out.println(scalar2);
        Var scalar3 = new Scalar(scalar1);
        System.out.println(scalar3);

        double[] arr = {3, 6, 2};
        Vector vector1 = new Vector(arr);
        System.out.println(vector1);
        Var vector2 = new Vector(vector1);
        System.out.println(vector2);
        Var vector3 = new Vector("{3, 7, 1, 9.0}");
        System.out.println(vector3);

        double[][] matrix = {{2, 7, 9}, {2, 5, 9}, {6,5,3}};
        Matrix matrix1 = new Matrix(matrix);
        System.out.println(matrix1);
        Var matrix2 = new Matrix(matrix1);
        System.out.println(matrix2);
        Var matrix3 = new Matrix("{{ 4, 6, 1 }, { 8, 1, 10 }, { 8, 8, 11 } }");
        System.out.println(matrix3);
    }
}

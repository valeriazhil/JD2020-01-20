package by.it.zhilenkova.jd01.jd01_07;

public class Runner {
    public static void main(String[] args) {
        System.out.println("This is from class Scalar:");
        Var a1 = new Scalar(3.14);
        System.out.println(a1);
        Var a2 = new Scalar("3.14");
        System.out.println(a2);
        Scalar scalar = new Scalar(3.14);
        Var a3 = new Scalar(scalar);
        System.out.println(a1);
        System.out.println("This is from class Vector");
        Var b1 = new Vector(new double[]{1,2,4});
        System.out.println(b1);
        Vector vector = new Vector(new double[]{1,2,4});
        Var b2 = new Vector(vector);
        System.out.println(b2);
        Var b3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(b3);
        //{ { 1.0, 2.0 }, { 3.0, 4.0 } }
        System.out.println("This is from class Matrix");
        Matrix c1 = new Matrix(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } });
        System.out.println(c1);
        Var c2 = new Matrix(c1);
        System.out.println(c2);
        Matrix c3 = new Matrix( "{{ 1.0, 2.0 }, { 3.0, 4.0 }}");
        System.out.println(c3);
        }
}

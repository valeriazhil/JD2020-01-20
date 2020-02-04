package by.it.dolgiy.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1 = new Scalar(3.1415);
        Scalar s2 = new Scalar(s1);
        Scalar s3 = new Scalar("3.1415");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        Vector v1 = new Vector(new double[]{1.0, 2.0, 4.0});
        Vector v2 = new Vector(v1);
        Vector v3 = new Vector("{1.0,2.0,4.0}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        Matrix m1 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Matrix m2 = new Matrix(m1);
        Matrix m3 = new Matrix("{{1.0,2.0},{3.0,4.0}}");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}


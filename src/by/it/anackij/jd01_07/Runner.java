package by.it.anackij.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var testVar = new Scalar(7.0);
        System.out.println(testVar);

        Scalar testVar2 = new Scalar("17.0");
        System.out.println(testVar2);

        Var testVar3 = new Scalar(testVar2);
        System.out.println(testVar3);

        double[] array = {1,2,3,5,6,7,8,9,2,5,1};
        Var vector=new Vector(array);
        System.out.println(vector);

    }
}

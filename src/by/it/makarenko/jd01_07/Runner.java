package by.it.makarenko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var testVar = new Scalar(7.0);
        System.out.println(testVar);

        Scalar testVar2 = new Scalar("4.0");
        System.out.println(testVar2);

        Var testVar3 = new Scalar(testVar2);
        System.out.println(testVar3);

        double[] array = {1,2,3,4,4,12.2,14};
        Var vector = new Vector(array);
        System.out.println(vector);

        Vector otherVec = new Vector(array);
        System.out.println(otherVec);

    }
}

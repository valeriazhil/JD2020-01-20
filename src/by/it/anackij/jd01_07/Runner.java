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

        String stringVector= "{1,2,3,5,5,1}";
        Var vector1=new Vector(stringVector);
        System.out.println(vector1);

        double[][] doublesArray = {{1,2,3},
                {5,6,7,8},
                {9,2,5,1}};
        Var testVar4 = new Matrix();
        System.out.println(testVar4);

        Var testVar5 = new Matrix(doublesArray);
        System.out.println(testVar5);

        Var testVar6 = new Matrix("{{1,2,3}{,4,5,6}}");
        System.out.println(testVar6);

    }
}

package by.it.degtyaryov.jd01_07;

class Runner {

    public static void main(String[] args) {
        Scalar scNumber = new Scalar(1.22);
        Var scScalar = new Scalar(scNumber);
        Var scString = new Scalar("3.333");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Скаляр из числа=").append(scNumber).append("\n")
                .append("Скаляр из скаляра=").append(scScalar).append("\n")
                .append("Скаляр из строки=").append(scString).append("\n\n");

        double[] array = new double[]{-10.9, -1.0, 0, 2.33, 5.489};
        Vector vctrArray = new Vector(array);
        Var vctrVector = new Vector(vctrArray);
        Var vctrString = new Vector("{-1, 2, 0, 3.6, -3, -6.2}");
        stringBuilder.append("Вектор из массива=").append(vctrArray).append("\n")
                .append("Вектор из вектори=").append(vctrVector).append("\n")
                .append("Вектор из строки=").append(vctrString).append("\n\n");

        double[][] deepArray = new double[][]{{1.2, 3}, {0, 1}, {-4, 5}};
        Matrix mtrxDeepArray = new Matrix(deepArray);
        Var mtrxMatrix = new Matrix(mtrxDeepArray);
        Var mtrxString = new Matrix("{{-1,2, 5.3},{0.12,-0.99, 0}, {3,4, 102}}");
        stringBuilder.append("Матрица из двумерного массива=").append(mtrxDeepArray).append("\n")
                .append("Матрица из матрицы=").append(mtrxMatrix).append("\n")
                .append("Матрица из строки=").append(mtrxString).append("\n");

        System.out.print(stringBuilder);
    }
}

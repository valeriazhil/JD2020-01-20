package by.it.cherkas.Calculator;


class MatrixCreator extends VarCreator{

    @Override
    Var createVar(String str) {
        return new Matrix(str);
    }
}

package by.it.zhuravaskarabahataya.calc;

class MatrixCreator extends VarCreator{

    @Override
    Var createVar(String str) {
        return new Matrix(str);
    }
}
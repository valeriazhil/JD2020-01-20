package by.it.cherkas.Calculator;


class ScalarCreator extends VarCreator{

    @Override
    Var createVar(String str) {
        return new Scalar(str);
    }
}

package by.it.gerasimov.calc;

abstract class VarCreator {

    abstract Var getVar(String line);
}

class ScalarCreator extends VarCreator {

    @Override
    Var getVar(String line) {
        return new Scalar(line);
    }
}

class VectorCreator extends VarCreator {

    @Override
    Var getVar(String line) {
        return new Vector(line);
    }
}

class MatrixCreator extends VarCreator {

    @Override
    Var getVar(String line) {
        return new Matrix(line);
    }
}
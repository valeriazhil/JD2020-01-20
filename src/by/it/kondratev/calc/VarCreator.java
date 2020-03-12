package by.it.kondratev.calc;

abstract class VarCreator {
    public abstract Var factoryMethod(String operand);
}

class ScalarCreator extends VarCreator {
    @Override
    public Var factoryMethod(String operand) {
        return new Scalar(operand);
    }
}

class VectorCreator extends VarCreator {
        @Override
        public Var factoryMethod(String operand) {
            return new Vector(operand);
        }
}

class MatrixCreator extends VarCreator {
    @Override
    public Var factoryMethod(String operand) {
        return new Matrix(operand);
    }
}

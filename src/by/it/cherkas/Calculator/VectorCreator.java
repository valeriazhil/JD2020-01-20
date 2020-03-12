package by.it.cherkas.Calculator;

class VectorCreator extends VarCreator{

    @Override
    Var createVar(String str) {
        return new Vector(str);
    }
}

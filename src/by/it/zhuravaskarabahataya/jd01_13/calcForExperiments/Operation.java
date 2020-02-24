package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;

public interface Operation {
//    Var add(Scalar other) throws CalcException;
//    Var add(Vector other) throws CalcException;
//    Var add(Matrix other) throws CalcException;
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}

package by.it.bunkov.calc;

import  java.util.Map;
import java.util.HashMap;


abstract class Var implements Operation {
    private static Map<String,Var> map=new HashMap<>();
            static Var createVar(String operand) throws CalcException {
                operand = operand.trim().replace("\\s+", "");
                if (operand.matches(Patterns.SCALAR))
                    return new Scalar(operand);
                if (operand.matches(Patterns.VECTOR))
                    return new Vector(operand);
                if (operand.matches(Patterns.MATRIX))
                    return new Matrix(operand);
                else {
                    Var var = map.get(operand);
                    if (var != null)
                        return var;
                    else
                        throw new CalcException("No var " + operand);


                }
                //TODO throw error
            }
    @Override
    public Var add(Var other) throws  CalcException {
        throw new CalcException ("Операция сложения "+this+"+"+other+" невозможна" );

    }

    @Override
    public Var sub(Var other) throws  CalcException {
        throw new CalcException ("Операция вычитания "+this+"-"+other+" невозможна" );
    }

    @Override
    public Var mul(Var other) throws  CalcException {
        throw new CalcException ("Операция умножения "+this+"*"+other+" невозможна" );

    }

    @Override
    public Var div(Var other) throws  CalcException {
        throw new CalcException ("Операция деления "+this+"/"+other+" невозможна" );

    }
}

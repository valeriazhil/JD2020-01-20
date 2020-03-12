package by.it.zhilenkova.jd02.ZhilenkovaCalcAll;

public class VarCreator {

   static Var createScalar(String operand){
        return new Scalar(operand);
    }

   static Var createVector(String operand){
       return new Vector(operand);
   }

    static Var createMatrix(String operand){
        return new Matrix(operand);
    }

}

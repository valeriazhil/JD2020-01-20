package by.it.zhuravaskarabahataya.calc;

 class ScalarCreator extends VarCreator{

  @Override
  Var createVar(String str) {
   return new Scalar(str);
  }
 }

package by.it.makarenko.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String operand){
         operand = operand.trim().replace(" ","");
         if (operand.matches(Patterns.SCALAR))
             return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Scalar(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Scalar(operand);
        return null;
    }

   @Override
   public String toString() {
       return "abstrac Var";
   }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this+" - "+other+ " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " +this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+" / "+other+ " невозможна");
        return null;
    }
}

package by.it.dolgiy.jd01_09;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+" / "+other+" невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "Var";
    }

    static Var createVar(String str){
        str = str.trim().replace("\\s+","");
        if (str.matches(Patterns.SCALAR)){
            return new Scalar(str);
        }
        else if (str.matches(Patterns.VECTOR)){
            return new Vector(str);
        }
        else if (str.matches(Patterns.MATRIX)){
            return new Matrix(str);
        }
        else
            return null;
    }

}

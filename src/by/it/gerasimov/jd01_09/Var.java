package by.it.gerasimov.jd01_09;

abstract class Var implements Operation {

    static Var create(String strValue) {
        strValue = strValue.trim().replace(" ", "");
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        } else {
            return null; //stub
            //TODO throw error
        }
    }

    public Var operate(Var other, String operator) {
        switch (operator) {
            case "+":
                return this.add(other);
            case "-":
                return this.sub(other);
            case "*":
                return this.mul(other);
            case "/":
                return this.div(other);
            default:
                return null;
        }
    }

    @Override
    public Var add(Var other) {
//        System.out.println("Операция " + this + " + " + other + " невозможна");
        return null;
    }
    @Override
    public Var sub(Var other) {
//        System.out.println("Операция " + this + " - " + other + " невозможна");
        return null;
    }
    @Override
    public Var mul(Var other) {
//        System.out.println("Операция " + this + " * " + other + " невозможна");
        return null;
    }
    @Override
    public Var div(Var other) {
//        System.out.println("Операция " + this + " / " + other + " невозможна");
        return null;
    }
    @Override
    public String toString() {
        return "X";
    }
    protected Var reverseAdd(Scalar other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseAdd(Vector other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseAdd(Matrix other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Scalar other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Vector other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Matrix other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Scalar other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Vector other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Matrix other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Scalar other) {
//        System.out.println("Операция " + other + " / " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Vector other) {
//        System.out.println("Операция " + vector + " / " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Matrix other) {
//        System.out.println("Операция " + vector + " / " + this + " невозможна");
        return null;
    }
}

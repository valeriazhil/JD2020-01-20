package by.it.gerasimov.calc;

class Printer {
    public void print(Var var) throws CalcException {
        if (var != null) {
            System.out.println(var);
        } else {
            throw new CalcException("Не найдена переменная");
        }
    }
}

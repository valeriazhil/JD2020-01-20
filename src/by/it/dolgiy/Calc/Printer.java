package by.it.dolgiy.Calc;

class Printer {
    void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }
}

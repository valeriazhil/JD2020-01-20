package by.it.dolgiy.jd02_04;

class Printer {
    void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }
}

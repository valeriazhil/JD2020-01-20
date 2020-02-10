package by.it.dolgiy.jd01_09;

class Printer {
    void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }
}

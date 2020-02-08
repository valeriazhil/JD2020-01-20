package by.it.akhmelev.jd01_09;

class Printer {
    public void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }
}

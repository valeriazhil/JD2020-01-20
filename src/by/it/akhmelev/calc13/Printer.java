package by.it.akhmelev.calc13;

class Printer {
    public void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }
}

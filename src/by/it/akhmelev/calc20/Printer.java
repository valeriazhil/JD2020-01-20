package by.it.akhmelev.calc20;

class Printer {
    public void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println("Error");
    }

    public void message(String message) {
            System.out.println(message);
    }
}

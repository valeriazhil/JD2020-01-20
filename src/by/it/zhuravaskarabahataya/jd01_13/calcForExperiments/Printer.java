package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;

class Printer {
    public void print(Var var) {
        if (var != null){
            System.out.println(var);
        }
        else {
            System.err.println("Error");
        }
    }
}

package by.it.makarenko.jd01_07;

class Scalar extends  Var{
    private double value;

    Scalar(String strScalar){
        value=Double.parseDouble(strScalar);
    }

    Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar other){
        this.value = other.value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}

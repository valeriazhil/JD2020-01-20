package by.it.akhmelev.jd01_07;

class Scalar extends Var{

    private double value;

    void test(){
        ///
    }

    Scalar(String strValue) {
        this.value=Double.parseDouble(strValue);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other) {
        this.value=other.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}

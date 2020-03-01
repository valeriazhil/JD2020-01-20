package by.it.lomazki.jd01_07;

class Vector extends by.it.lomazki.jd01_07.Var {

    private double [] value;

    Vector(double[] value){
        this.value = value;
    }
    Vector(Vector vector) {
        this.value = vector.value;
    }
    Vector(String strVector) {
        // {2.0, 3.0, 4.0}
        String[] arrStrVector = strVector.replaceAll("[{} ]+", "").split(",");
        this.value = new double[arrStrVector.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(arrStrVector[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter).append(value[i]);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

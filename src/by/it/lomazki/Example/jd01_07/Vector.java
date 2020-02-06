package by.it.lomazki.Example.jd01_07;

class Vector extends Var {
    private double [] value;

    Vector(double[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    Vector(Vector vector) {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
    }


}

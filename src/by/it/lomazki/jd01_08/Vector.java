package by.it.lomazki.jd01_08;


class Vector extends Var{

    private double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter="";
        for (double value : values) {
            out.append(delimiter).append(value);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}

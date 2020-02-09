package by.it.demchik.jd01_08;

class Vector extends Var{

    private double[] values;

    Vector(double[] values) {
        this.values = values;
    }


    Vector(Vector someVector) {
        this(someVector.values);
    }

    public Vector(String str) {
        String[] strings = str.replace(" ", "")
                .replace("{", "")
                .replace("}", "").split(",");
        values=new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i]=Double.parseDouble(strings[i]);
        }
    }




    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double value : values) {
            out.append(delimiter).append(value);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
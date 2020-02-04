package by.it.kondratev.jd01_07;

class Vector extends Var {

    private double[] value;

    Vector(double [] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        value = vector.value;
    }


    Vector(String  strVector) {
        strVector = strVector.trim();
        strVector = strVector.substring(1, strVector.length() - 1);
        String[] arr = strVector.split(",");
        double mas [] = new double[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            mas[i] = Double.parseDouble(arr[i]);
        }
        value = mas;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{"+value[0]);
        for (int i = 1; i < value.length; i++) {
            s.append(", ").append(value[i]);
        }
        s.append("}");
        return s.toString();
    }



}


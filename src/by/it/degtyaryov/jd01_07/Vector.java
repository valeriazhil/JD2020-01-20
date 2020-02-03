package by.it.degtyaryov.jd01_07;

import java.util.Arrays;

/**
 * @author DEA
 */
class Vector extends Var {

    private double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

    /*Vector(String strVector) {
        this.values = values;
    }*/

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
package by.it.kondratev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    Var s1 = new Scalar(5);
    Var v1 = new Vector("{1,2,3}");
    Var v2 = new Vector("{2,3,4}");
    Var v3 = new Vector("{2,3,4,5}");
    Var m1 = new Matrix("{{1,2,3},{1,2,3}}");

    @Test
    public void addVS() throws CalcException {
        assertEquals("{6.0, 7.0, 8.0}", v1.add(s1).toString());
    }

    @Test
    public void addVV1() throws CalcException {
        assertEquals("{3.0, 5.0, 7.0}", v1.add(v2).toString());
    }

    @Test(expected = CalcException.class)
    public void addVV2() throws CalcException {
        v1.add(v3);
    }

    @Test(expected = CalcException.class)
    public void addVM() throws CalcException {
        v1.add(m1);
    }

    @Test
    public void subVS() throws CalcException {
        assertEquals("{-4.0, -3.0, -2.0}", v1.sub(s1).toString());
    }

    @Test
    public void subVV1() throws CalcException {
        assertEquals("{-1.0, -1.0, -1.0}", v1.sub(v2).toString());
    }

    @Test(expected = CalcException.class)
    public void subVV2() throws CalcException {
        v1.sub(v3);
    }

    @Test(expected = CalcException.class)
    public void subVM() throws CalcException {
        v1.sub(m1);
    }

    @Test
    public void mulVS() throws CalcException {
        assertEquals("{5.0, 10.0, 15.0}", v1.mul(s1).toString());
    }

    @Test
    public void mulVV1() throws CalcException {
        assertEquals("20.0", v1.mul(v2).toString());
    }

    @Test(expected = CalcException.class)
    public void mulVV2() throws CalcException {
        v1.mul(v3);
    }

    @Test(expected = CalcException.class)
    public void mulVM() throws CalcException {
        v1.mul(m1);
    }

    @Test
    public void divVS() throws CalcException {
        assertEquals("{0.2, 0.4, 0.6}", v1.div(s1).toString());
    }

    @Test(expected = CalcException.class)
    public void divVV() throws CalcException {
       v1.div(v2);
    }

    @Test(expected = CalcException.class)
    public void divVM() throws CalcException {
       v1.div(m1);
    }

}
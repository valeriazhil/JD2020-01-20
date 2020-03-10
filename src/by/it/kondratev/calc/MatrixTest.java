package by.it.kondratev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    Var s1 = new Scalar(5);
    Var v1 = new Vector("{1,2,3}");
    Var v2 = new Vector("{2,3}");
    Var v3 = new Vector("{2,3,4,5}");
    Var m1 = new Matrix("{{1,2,3},{1,2,3}}");
    Var m2 = new Matrix("{{1,2},{1,2},{1,2}}");


    @Test
    public void addMS() throws CalcException {
        assertEquals("{{6.0, 7.0, 8.0}, {6.0, 7.0, 8.0}}", m1.add(s1).toString());
    }

    @Test(expected = CalcException.class)
    public void addMV() throws CalcException {
        m1.add(v1);
    }

    @Test(expected = CalcException.class)
    public void addMM1() throws CalcException {
        m1.add(m2);
    }

    @Test
    public void addMM2() throws CalcException {
        assertEquals("{{2.0, 4.0, 3.0}, {2.0, 4.0, 3.0}}", m1.add(m1).toString());
    }

    @Test
    public void subMS() throws CalcException {
        assertEquals("{{-4.0, -3.0, -2.0}, {-4.0, -3.0, -2.0}}", m1.sub(s1).toString());
    }

    @Test(expected = CalcException.class)
    public void subMV() throws CalcException {
        m1.sub(v1);
    }

    @Test(expected = CalcException.class)
    public void subMM1() throws CalcException {
        m1.sub(m2);
    }

    @Test
    public void subMM2() throws CalcException {
        assertEquals("{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}", m1.sub(m1).toString());
    }

    @Test
    public void mulMS() throws CalcException {
        assertEquals("{{5.0, 10.0, 15.0}, {5.0, 10.0, 15.0}}", m1.mul(s1).toString());
    }

    @Test
    public void mulMV1() throws CalcException {
        assertEquals("{14.0, 14.0}", m1.mul(v1).toString());
    }

    @Test(expected = CalcException.class)
    public void mulMV2() throws CalcException {
        m1.mul(v2);
    }

    @Test(expected = CalcException.class)
    public void mulMM1() throws CalcException {
        m1.mul(m1);
    }

    @Test
    public void mulMM2() throws CalcException {
        assertEquals("{{6.0, 12.0}, {6.0, 12.0}}", m1.mul(m2).toString());
    }

    @Test
    public void divMS() throws CalcException {
        assertEquals("{{0.2, 0.4, 0.6}, {0.2, 0.4, 0.6}}", m1.div(s1).toString());
    }

    @Test(expected = CalcException.class)
    public void divMV() throws CalcException {
        m1.div(v1);
    }

    @Test(expected = CalcException.class)
    public void divMM() throws CalcException {
        m1.div(m2);
    }
}
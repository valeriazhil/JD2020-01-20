package by.it.kondratev.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest {

    Var s1 = new Scalar(5);
    Var s2 = new Scalar(3);
    Var v1 = new Vector("{1,2,3}");
    Var m1 = new Matrix("{{1,2,3},{1,2,3}}");

    @Test
    public void addSS() throws CalcException {
        assertEquals("8.0", s1.add(s2).toString());
    }

    @Test
    public void addSV() throws CalcException {
        assertEquals("{6.0, 7.0, 8.0}", s1.add(v1).toString());
    }

    @Test
    public void addSM() throws CalcException {
        assertEquals("{{6.0, 7.0, 8.0}, {6.0, 7.0, 8.0}}", s1.add(m1).toString());
    }

    @Test
    public void subSS() throws CalcException {
        assertEquals("2.0", s1.sub(s2).toString());
    }

    @Test
    public void subSV() throws CalcException {
        assertEquals("{4.0, 3.0, 2.0}", s1.sub(v1).toString());
    }

    @Test
    public void subSM() throws CalcException {
        assertEquals("{{4.0, 3.0, 2.0}, {4.0, 3.0, 2.0}}", s1.sub(m1).toString());
    }

    @Test
    public void mulSS() throws CalcException {
        assertEquals("15.0", s1.mul(s2).toString());
    }

    @Test
    public void mulSV() throws CalcException {
        assertEquals("{5.0, 10.0, 15.0}", s1.mul(v1).toString());
    }

    @Test
    public void mulSM() throws CalcException {
        assertEquals("{{5.0, 10.0, 15.0}, {5.0, 10.0, 15.0}}", s1.mul(m1).toString());
    }

    @Test
    public void divSS() throws CalcException {
        Double expected = 5.0/3.0;
        assertEquals(expected.toString(), s1.div(s2).toString());
    }

    @Test(expected = CalcException.class)
    public void divSV() throws CalcException {
        s1.div(v1);
    }

    @Test(expected = CalcException.class)
    public void divSM() throws CalcException {
        s1.div(m1);
    }
}
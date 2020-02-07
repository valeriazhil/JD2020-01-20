package by.it.gerasimov.jd01_08;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {
    @Test
    public void addSS() {
        Var s1 = new Scalar(3);
        Var s2 = new Scalar(4);
        assertEquals(new Scalar(7), s1.add(s2));
    }

    @Test
    public void addSV() {
        Var s1 = new Scalar(3);
        Var v2 = new Vector(new double[]{1, 2, 3.1});
        assertEquals(new Vector(new double[]{4, 5, 6.1}), s1.add(v2));
    }

    @Test
    public void addSM() {
        Var s1 = new Scalar(2);
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertEquals(new Matrix("{{3, 4, 5}, {6, 7, 8}, {5, 4, 3}}"), s1.add(m2));
    }

    @Test
    public void subSS() {
        Var s1 = new Scalar(3);
        Var s2 = new Scalar(4);
        assertEquals(new Scalar(-1), s1.sub(s2));
    }

    @Test
    public void subSV() {
        Var s1 = new Scalar(3);
        Var v2 = new Vector(new double[]{1, 2, 4});
        assertEquals(new Vector(new double[]{2, 1, -1}), s1.sub(v2));
    }

    @Test
    public void subSM() {
        Var s1 = new Scalar(2);
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertEquals(new Matrix("{{1, 0, -1}, {-2, -3, -4}, {-1, 0, 1}}"), s1.sub(m2));
    }

    @Test
    public void mulSS() {
        Var s1 = new Scalar(3);
        Var s2 = new Scalar(4);
        assertEquals(new Scalar(12), s1.mul(s2));
    }

    @Test
    public void mulSV() {
        Var s1 = new Scalar(3);
        Var v2 = new Vector(new double[]{1, 2, 4});
        assertEquals(new Vector(new double[]{3, 6, 12}), s1.mul(v2));
    }

    @Test
    public void mulSM() {
        Var s1 = new Scalar(2);
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertEquals(new Matrix("{{2, 4, 6}, {8, 10, 12}, {6, 4, 2}}"), s1.mul(m2));
    }

    @Test
    public void divSS() {
        Var s1 = new Scalar(8);
        Var s2 = new Scalar(4);
        assertEquals(new Scalar(2), s1.div(s2));
    }

    @Test
    public void divSV() {
        Var s1 = new Scalar(3);
        Var v2 = new Vector(new double[]{1, 2, 4});
        assertNull(s1.div(v2));
    }

    @Test
    public void divSM() {
        Var s1 = new Scalar(2);
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertNull(s1.div(m2));
    }

    @Test
    public void addVS() {
        Var v1 = new Vector(new double[]{1, 2, 3.1});
        Var s2 = new Scalar(3);
        assertEquals(new Vector(new double[]{4, 5, 6.1}), v1.add(s2));
    }

    @Test
    public void addVV() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{4, 5, 6});
        assertEquals(new Vector(new double[]{5, 7, 9}), v1.add(v2));
    }

    @Test
    public void addVM() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertNull(v1.add(m2));
    }

    @Test
    public void subVS() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var s2 = new Scalar(3);
        assertEquals(new Vector(new double[]{-2, -1, 0}), v1.sub(s2));
    }

    @Test
    public void subVV() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{4, 5, 5});
        assertEquals(new Vector(new double[]{-3, -3, -2}), v1.sub(v2));
    }

    @Test
    public void subVM() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertNull(v1.sub(m2));
    }

    @Test
    public void mulVS() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var s2 = new Scalar(3);
        assertEquals(new Vector(new double[]{3, 6, 9}), v1.mul(s2));
    }

    @Test
    public void mulVV() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{4, 5, 5});
        assertEquals(new Scalar(29), v1.mul(v2));
    }

    @Test
    public void mulVM() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertEquals(new Vector("{{18, 18, 18}"), v1.mul(m2));
    }

    @Test
    public void divVS() {
        Var v1 = new Vector(new double[]{2, 4, 6});
        Var s2 = new Scalar(2);
        assertEquals(new Vector(new double[]{1, 2, 3}), v1.div(s2));
    }

    @Test
    public void divVV() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{4, 5, 5});
        assertNull(v1.div(v2));
    }

    @Test
    public void divVM() {
        Var v1 = new Vector(new double[]{1, 2, 3});
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        assertNull(v1.div(m2));
    }

    @Test
    public void addMS() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var s2 = new Scalar(2);
        assertEquals(new Matrix("{{3, 4, 5}, {6, 7, 8}, {5, 4, 3}}"), m1.add(s2));
    }

    @Test
    public void addMV() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var v2 = new Vector(new double[]{1, 2, 3});
        assertNull(m1.add(v2));
    }

    @Test
    public void addMM() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var m2 = new Matrix("{{3, 2, 1}, {4, 5, 0}, {3, 2, 1}}");
        assertEquals(new Matrix("{{4, 4, 4}, {8, 10, 6}, {6, 4, 2}}"), m1.add(m2));
    }

    @Test
    public void subMS() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var s2 = new Scalar(2);
        assertEquals(new Matrix("{{-1, 0, 1}, {2, 3, 4}, {1, 0, -1}}"), m1.sub(s2));
    }

    @Test
    public void subMV() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var v2 = new Vector(new double[]{1, 2, 3});
        assertNull(m1.sub(v2));
    }

    @Test
    public void subMM() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var m2 = new Matrix("{{3, 2, 1}, {4, 5, 0}, {3, 2, 2}}");
        assertEquals(new Matrix("{{-2, 0, 2}, {0, 0, 6}, {0, 0, -1}}"), m1.sub(m2));
    }

    @Test
    public void mulMS() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var s2 = new Scalar(2);
        assertEquals(new Matrix("{{2, 4, 6}, {8, 10, 12}, {6, 4, 2}}"), m1.mul(s2));
    }

    @Test
    public void mulMV() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}");
        Var v2 = new Vector(new double[]{1, 2, 3});
        assertEquals(new Vector("{14, 32, 50}"), m1.mul(v2));
    }

    @Test
    public void mulMM() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}");
        Var m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}");
        assertEquals(new Matrix("{{30, 36, 42}, {66, 81, 96}, {102, 126, 150}}"), m1.mul(m2));
    }

    @Test
    public void divMS() {
        Var m1 = new Matrix("{{2, 2, 4}, {4, 8, 6}, {2, 2, 0}}");
        Var s2 = new Scalar(2);
        assertEquals(new Matrix("{{1, 1, 2}, {2, 4, 3}, {1, 1, 0}}"), m1.div(s2));
    }

    @Test
    public void divMV() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var v2 = new Vector(new double[]{1, 2, 3});
        assertNull(m1.div(v2));
    }

    @Test
    public void divMM() {
        Var m1 = new Matrix("{{1, 2, 3}, {4, 5, 6}, {3, 2, 1}}");
        Var m2 = new Matrix("{{3, 2, 1}, {4, 5, 0}, {3, 2, 2}}");
        assertNull(m1.div(m2));
    }
}
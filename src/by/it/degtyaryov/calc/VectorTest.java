package by.it.degtyaryov.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    private static final double DELTA = 1e-5;
    private Parser parser = new Parser();

    @Test
    public void add() throws CalcException {
        String expression = "{1, 2, 3} + {4, 5, 6}";
        Var expected = new Vector("{5, 7, 9}");
        Var actualResult = parser.calc(expression);
        assertEquals(expected, actualResult);
    }

    @Test(expected = CalcException.class)
    public void addDifferentSize() throws CalcException {
        String expression = "{1, 2, 3} + {4, 5, 6, 7}";
        parser.calc(expression);
    }

    @Test
    public void sub() throws CalcException {
        String expression = "{10, 2, -6.99} - {4, 5, -6.99}";
        Var expected = new Vector("{6, -3, 0}");
        Var actualResult = parser.calc(expression);
        assertEquals(expected, actualResult);
    }

    @Test(expected = CalcException.class)
    public void subDifferentSize() throws CalcException {
        String expression = "{10, 2, -6.99} - {4, 5, -6.99, 0}";
        parser.calc(expression);
    }

    @Test
    public void mul() throws CalcException {
        String expression = "{10, 2, -6.99} * {4, 5, -6.99}";
        double expected = 98.8601;
        Var actualResult = parser.calc(expression);
        double actual = Double.parseDouble(actualResult.toString());
        assertEquals(expected, actual, DELTA);
    }

    @Test(expected = CalcException.class)
    public void mulDifferentSize() throws CalcException {
        String expression = "{10, 2, -6.99} * {4, 1}";
        parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void div() throws CalcException {
        String expression = "{10.55, 20, 0} / {10.55, 5, 1.9}";
        parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void divDifferentSize() throws CalcException {
        String expression = "{10, 2, -6.99} / {4}";
        parser.calc(expression);
    }

    @Test
    public void stringToVector() {
        String expression = "{1234.01, 0.0, -2.0}";
        Var actualResult = new Vector(expression);
        assertEquals(expression, actualResult.toString());
    }
}
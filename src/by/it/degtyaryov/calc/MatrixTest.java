package by.it.degtyaryov.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    private Parser parser = new Parser();

    @Test
    public void add() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}, {5, 16.0}} + {{6, 5.01}, {-10.35, 4}, {1, 1.11}}";
        Var expected = new Matrix("{{6, 6}, {-13.85, 8}, {6, 17.11}}");
        Var actualResult = parser.calc(expression);
        assertEquals(expected, actualResult);
    }

    @Test(expected = CalcException.class)
    public void addDifferentSize() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}} + {{6, 5.01}, {1, 2}, {2, 1}}";
        parser.calc(expression);
    }
	
	@Test
    public void sub() throws CalcException {
        String expression = "{{10, 1}, {-3, 4}} - {{5, 5}, {-7, 4}}";
        Var expected = new Matrix("{{5, -4}, {4, 0}}");
        Var actualResult = parser.calc(expression);
        assertEquals(expected, actualResult);
    }

    @Test(expected = CalcException.class)
    public void subDifferentSize() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}} - {{6, 5.01}, {1, 1}, {12, 12}}";
        parser.calc(expression);
    }
	
	@Test
    public void mul() throws CalcException {
        String expression = "{{0, 1}, {-2, 3}} * {{2, 0}, {1, -2}}";
        Var expected = new Matrix("{{1, -2}, {-1, -6}}");
        Var actualResult = parser.calc(expression);
        assertEquals(expected, actualResult);
    }

    @Test(expected = CalcException.class)
    public void mulDifferentSize() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}} * {{6, 5.01}, {0, 1}, {0, 0}}";
        parser.calc(expression);
    }
	
	@Test(expected = CalcException.class)
    public void div() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}, {5, 16.0}} / {{6, 5.01}, {-10.35, 4}, {1, 1.11}}";
        parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void divDifferentSize() throws CalcException {
        String expression = "{{0, 0.99}, {-3.5, 4}} / {{6, 5.01}}";
        parser.calc(expression);
    }

    @Test
    public void stringToMatrix() {
        String expression = "{{1234.01, 0.0, -2.0}, {1.2, 1.1, 2.9}, {1.2, 0.0, -1.1}}";
        Var actualResult = new Matrix(expression);
        assertEquals(expression, actualResult.toString());
    }
}
package by.it.zhuravaskarabahataya.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calcScalarAddScalar() throws CalcException {
        double expected = 7.3;
        Parser parser = new Parser();
        String expression = "A=2+5.3";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void calcScalarSubScalar() throws CalcException {
        double expected = 10;
        Parser parser = new Parser();
        String expression = "20-10";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void calcScalarMulScalar() throws CalcException {
        double expected = 25.55;
        Parser parser = new Parser();
        String expression = "B=7.3*3.5";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void calcScalarDivScalar() throws CalcException {
        double expected = 3;
        Parser parser = new Parser();
        String expression = "27/9";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test(expected = CalcException.class)
    public void calcScalarDivNull() throws CalcException {
        Parser parser = new Parser();
        String expression = "27/0";
        parser.calc(expression);
    }

    @Test
    public void calcAddMultipleScalars() throws CalcException {
        double expected = 25;
        Parser parser = new Parser();
        String expression = "B1=B+0.11*-5";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void calcA4() throws CalcException {
        double expected = 2.65;
        Parser parser = new Parser();
        String expression = "B2=7.3/2-1";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void calcScalarAddVector() throws CalcException {
        String expected = "{2.0, 4.0, 6.0}";
        Parser parser = new Parser();
        String expression = "{1, 3, 5} + 1";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar add vector ", expected, actual);
    }

    @Test
    public void calcScalarSubVector() throws CalcException {
        String expected = "{0.0, 2.0, 4.0}";
        Parser parser = new Parser();
        String expression = "{1, 3, 5} - 1";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar sub vector ", expected, actual);
    }

    @Test
    public void calcScalarMulVector() throws CalcException {
        String expected = "{2.0, 6.0, 10.0}";
        Parser parser = new Parser();
        String expression = "{1, 3, 5} * 2";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar mul vector ", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void calcScalarDivVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "7/{1, 2}";
        parser.calc(expression);
    }


    @Test
    public void calcScalarAddMatrix() throws CalcException {
        String expected = "{{2.0, 4.0, 6.0}, {1.0, 2.0, 3.0}}";
        Parser parser = new Parser();
        String expression = "1+{{1, 3, 5},{0, 1, 2}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar add matrix ", expected, actual);
    }

    @Test
    public void calcScalarSubMatrix() throws CalcException {
        String expected = "{{2.0, 4.0, 2.0}, {1.0, 2.0, 3.0}}";
        Parser parser = new Parser();
        String expression = "3 - {{1, -1, 1},{2, 1, 0}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar sub matrix ", expected, actual);
    }

    @Test
    public void calcScalarMulMatrix() throws CalcException {
        String expected = "{{4.0, 8.0, 12.0}, {2.0, 4.0, 6.0}}";
        Parser parser = new Parser();
        String expression = "{{2.0, 4.0, 6.0}, {1.0, 2.0, 3.0}} * 2";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect scalar mul matrix ", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void calcScalarDivMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "7/{{2, 3}, {1, 2}}";
        parser.calc(expression);
    }

    @Test
    public void calcVectorAddVector() throws CalcException {
        String expected = "{1.0, 2.0, 3.0}";
        Parser parser = new Parser();
        String expression = "{0, 0, 3} + {1, 2, 0}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect vector add ", expected, actual);
    }

    @Test
    public void calcVectorSubVector() throws CalcException {
        String expected = "{0.0, 1.0, 2.0}";
        Parser parser = new Parser();
        String expression = "{1.0, 2.0, 3.0}- {1.0, 1.0, 1.0}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect vector seb vector ", expected, actual);
    }

    @Test
    public void calcVectorMulVector() throws CalcException {
        String expected = "6.0";
        Parser parser = new Parser();
        String expression = "{1.0, 2.0, 3.0}* {1.0, 1.0, 1.0}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect vector mul vector ", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void calcVectorDivVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3}/{2,3,4}";
        parser.calc(expression);
    }

    @Test
    public void calcMatrixAddMatrix() throws CalcException {
        String expected = "{{3.0, 6.0}, {7.0, 0.0}}";
        Parser parser = new Parser();
        String expression = "{{2, 4} , {0, 0}} + {{1, 2},{7, 0}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect matrix add matrix", expected, actual);
    }

    @Test
    public void calcMatrixSubMatrix() throws CalcException {
        String expected = "{{1.0, 2.0}, {-7.0, 0.0}}";
        Parser parser = new Parser();
        String expression = "{{2, 4} , {0, 0}} - {{1, 2},{7, 0}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect matrix seb matrix ", expected, actual);
    }

    @Test
    public void calcMatrixMulMatrix() throws CalcException {
        String expected = "{{30.0, 4.0}, {0.0, 0.0}}";
        Parser parser = new Parser();
        String expression = "{{2, 4} , {0, 0}} * {{1, 2},{7, 0}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Incorrect matrix mul matrix ", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void calcMatrixDivMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{2, 4} , {0, 0}} / {{1, 2},{7, 0}}";
        parser.calc(expression);
    }

    @Test
    public void testVarCreation() throws CalcException {
        String expectedScalar = "2.0";
        String expectedVector = "{1.0, 2.0, 5.0}";
        String expectedMatrix = "{{2.0, 3.0, 77.0}, {6.0, 2.0, 9.0}}";
        Parser parser = new Parser();
        String expressionScalar = " A =2";
        String expressionVector = " B ={1, 2, 5}";
        String expressionMatrix = " M =  {{2.0, 3.0, 77.0}, {6.0, 2.0, 9.0}}";
        Var resultScalar = parser.calc(expressionScalar);
        Var resultVector = parser.calc(expressionVector);
        Var resultMatrix = parser.calc(expressionMatrix);
        assertEquals("Var scalar creation invalid ", expectedScalar, resultScalar.toString());
        assertEquals("Var vector creation invalid ", expectedVector, resultVector.toString());
        assertEquals("Var vector creation invalid ", expectedMatrix, resultMatrix.toString());
    }
}
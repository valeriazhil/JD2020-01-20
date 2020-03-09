package by.it.dolgiy.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void a_1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        String expression = "A=2+5.3";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("a_1 : expression " + expression + " result " + actual);
    }

    @Test
    public void a_2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        String expression = "B=A*3.5";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("a_2 : expression " + expression + " result " + actual);
    }

    @Test
    public void a_3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        String expression = "B1=B+0.11*-5";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("a_3 : expression " + expression + " result " + actual);
    }

    @Test
    public void a_4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        String expression = "B2=A/2-1";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("a_4 : expression " + expression + " result " + actual);
    }

    @Test
    public void b_1() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        String expression = "C=B+(A*2)";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("b_1 : expression " + expression + " result " + actual);
    }

    @Test
    public void b_2() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        String expression = "D=((C-0.15)-20)/(7-5)";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals("Error:scalar",expected,actual,1e-5);
        System.out.println("b_2 : expression " + expression + " result " + actual);
    }

    @Test
    public void b_3() throws Exception {
        String expected = "{10,15}";
        Parser parser = new Parser();
        String expression = "E={2,3}*(D/2)";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("b_3 : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixAddScalar() throws Exception {
        String expected = "{{2.0, 3.0}, {4.0, 5.0}}";
        Parser parser = new Parser();
        String expression = "MAS={{1,2},{3,4}}+1";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixAddScalar : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixAddMatrix() throws Exception {
        String expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        Parser parser = new Parser();
        String expression = "MAM={{1,2},{3,4}}+{{1,2},{3,4}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixAddMatrix : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixSubScalar() throws Exception {
        String expected = "{{0.0, 1.0}, {2.0, 3.0}}";
        Parser parser = new Parser();
        String expression = "MSS={{1,2},{3,4}}-1";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixSubScalar : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixSumMatrix() throws Exception {
        String expected = "{{0.0, 0.0}, {0.0, 0.0}}";
        Parser parser = new Parser();
        String expression = "MSM={{1,2},{3,4}}-{{1,2},{3,4}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixSumMatrix : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixMulScalar() throws Exception {
        String expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        Parser parser = new Parser();
        String expression = "MMS={{1,2},{3,4}}*2";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixMulScalar : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixMulVector() throws Exception {
        String expected = "{5.0, 11.0}";
        Parser parser = new Parser();
        String expression = "MMV={{1,2},{3,4}}*{1,2}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixMulVector : expression " + expression + " result " + actual);
    }

    @Test
    public void matrixMulMatrix() throws Exception {
        String expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        Parser parser = new Parser();
        String expression = "MMM={{1,2},{3,4}}*{{1,2},{3,4}}";
        Var var = parser.calc(expression);
        String actual = var.toString();
        assertEquals("Error:scalar",expected,actual);
        System.out.println("matrixMulMatrix : expression " + expression + " result " + actual);
    }

}
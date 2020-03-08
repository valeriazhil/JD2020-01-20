package by.it.akhmelev.calc19;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void calc() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        String expression = "A=2+5.31";
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-5);


    }

}
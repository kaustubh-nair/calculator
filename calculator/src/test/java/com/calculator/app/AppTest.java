package com.calculator.app;

import static org.junit.Assert.assertEquals;
import com.calculator.app.App;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testSquareRoot()
    {
        double ret = App.squareRoot(1);
        assertEquals(1.0, ret, 0.0f);

        ret = App.squareRoot(4);
        assertEquals(2.0, ret, 0.0f);

        ret = App.squareRoot(16);
        assertEquals(4.0, ret, 0.0f);
    }

    @Test
    public void testFactorial()
    {
        double ret = App.factorial(1);
        assertEquals(1.0, ret, 0.0f);

        ret = App.factorial(2);
        assertEquals(2.0, ret, 0.0f);

        ret = App.factorial(4);
        assertEquals(24.0, ret, 0.0f);
    }
    @Test
    public void testPower()
    {
        double ret = App.power(1,1);
        assertEquals(1.0, ret, 0.0f);

        ret = App.power(2, 2);
        assertEquals(4.0, ret, 0.0f);

        ret = App.power(4, 3);
        assertEquals(64.0, ret, 0.0f);
    }
    @Test
    public void testLogarithm()
    {
        double ret = App.logarithm(1);
        assertEquals(0.0, ret, 0.0f);

        ret = App.logarithm(2);
        assertEquals(0.693147, ret, 0.01f);
    }
}

package sample;

import org.junit.Test;

import static org.junit.Assert.*;


import org.junit.Rule;

import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    //@Test
    //public void add() {
    //}

    //@Test
    //public void subtract() {
    //}

    //@Test
    //public void multiply() {
    //}

    //@Test
    //public void divide() {
    //}

    //@Test
    //public void power() {
    //}

    //@Test
    //public void powerOf10() {
    //}

    //@Test
    //public void sqrt() {
    //}

    //@Test
    //public void cbrt() {
    //}
    @Test
    public void addition() {
        assertEquals(20, Calculator.add(5, 15), 0.0f);
    }

    @Test
    public void additionNegativeNumber() {
        assertEquals(198, Calculator.add(321, -123), 0.0f);
    }

    @Test
    public void subtractionPositive() {
        assertEquals(2, Calculator.subtract(17, 15), 0.0f);
    }

    @Test
    public void subtractionNegative() {
        assertEquals(-2, Calculator.subtract(15, 17), 0.0f);
    }

    @Test
    public void multipliaction() {
        assertEquals(-5.0625, Calculator.multiply(2.25, -2.25), 0.0f);
    }

    @Test
    public void multipliactionByZero() {
        assertEquals(0, Calculator.multiply(2.25, 0), 0.0f);
    }

    @Test
    public void division() {
        assertEquals(-5, Calculator.divide(2.5, -0.5), 0.0f);
    }

    @Test
    public void sqrt() {
        assertEquals(32, Calculator.sqrt(1024), 0.0f);
    }

    @Test
    public void cbrt() {
        assertEquals(3, Calculator.cbrt(27), 0.0f);
    }

    @Test
    public void cbrtNegative() {
        assertEquals(-3, Calculator.cbrt(-27), 0.0f);
    }

    @Test
    public void power() {
        assertEquals(1024, Calculator.power(2, 10), 0.0f);
    }

    @Test
    public void zeroPower() {
        assertEquals(1, Calculator.power(2, 0), 0.0f);
    }

    @Test
    public void powerOf10() {
        assertEquals(10000, Calculator.powerOf10(4), 0.0f);
    }

    @Test
    public void divisionException() throws ArithmeticException  {
        exception.expect(ArithmeticException.class);
        exception.expectMessage(("Divide by zero!"));
        Calculator.divide(4, 0);
    }

    @Test
    public void sqrtException() throws ArithmeticException  {
        exception.expect(ArithmeticException.class);
        exception.expectMessage(("Square root of negative number!"));
        Calculator.sqrt(-2);
    }
}
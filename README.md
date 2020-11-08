# Calculator-JavaFX

- ***Name and Surname:*** *Selma Nezihoglu*
- ***Email:*** *selma.nezihoglu@iaau.edu.kg*
- *Computer Science Department of Alatoo International University.*
- *Individual midterm project for CS 201: Object Oriented Programming.*
It is a basic calculator that can do 4 function, power, squareroot and cuberoot.

## Project Description
A basic GUI calculator that does 4 function, power, squareroot and cuberoot. It is created with **JavaFX**.
There are **5** classes and files, which are;

- ***Main.java :*** To start the Gui.
- ***Calculator.java :*** Where all of the functions are written.
- ***CalculatorTest.java :*** Test class made with JUnit testing (5 Tests are made).
- ***Application.css :*** To design the buttons.
- ***text.txt :*** To read and print the text inside.
- ***out.txt :*** Prints the results in here.

### 15 JUnit tests:

``` Java
package sample;

import org.junit.Test;

import static org.junit.Assert.*;


import org.junit.Rule;

import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
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
```

#### How the calculator looks like:
![Calculator](https://user-images.githubusercontent.com/64955154/98462600-a97e9180-21df-11eb-9e4f-8fa240e093c0.PNG)


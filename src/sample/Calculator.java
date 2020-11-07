package sample;

public class Calculator {
    public static double add(double first, double second) {
        return first + second;
    }

    public static double subtract(double first, double second) {
        return first - second;
    }

    public static double multiply(double first, double second) {
        return first * second;
    }

    public static double divide(double first, double second) throws ArithmeticException {
        // I know that double 1/0 = infinity
        // just for testing exceptions
        if(second == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return first / second;
    }

    public static double power(double number, double power) {
        return Math.pow(number, power);
    }

    public static double powerOf10(double power) {
        return Math.pow(10, power);
    }

    public static double sqrt(double number)  throws ArithmeticException {
        if(number < 0) {
            throw new ArithmeticException("Square root of negative number!");
        }
        return Math.sqrt(number);
    }

    public static double cbrt(double number) {
        return Math.cbrt(number);

    }

}

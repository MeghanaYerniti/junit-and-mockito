package org.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public int power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Negative exponent not supported for integers");
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public int sqrt(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate sqrt of negative number");
        }
        int root = (int) Math.sqrt(a);
        if (root * root != a) {
            throw new IllegalArgumentException("Not a perfect square: " + a);
        }
        return root;
    }
}

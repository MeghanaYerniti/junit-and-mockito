package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();


    // asserEquals(actualValue, returnedValue, "msg")
    @Test
    void testAdditionPositiveNumbers() {
        assertEquals(8, calc.add(5, 3));
//        assertEquals(5, calc.add(5, 3));
    }

    @Test
    void testAdditionWithNegative() {
        assertEquals(-2, calc.add(-5, 3));
//        assertEquals(2, calc.add(-5, 3));
    }

    @Test
    void testAdditionWithZero() {
        assertEquals(5, calc.add(5, 0));
//        assertEquals(8, calc.add(5, 0));
    }

    @Test
    void testAdditionWithZeroNotEqual() {
//        assertEquals(5, calc.add(5, 0));
        assertNotEquals(8, calc.add(5, 0));
    }

    @Test
    void testSubtractionPositive() {
        assertEquals(2, calc.subtract(5, 3));
//        assertEquals(-5, calc.subtract(5, 3));
    }

    @Test
    void testSubtractionNegativeResult() {
        assertEquals(-2, calc.subtract(3, 5));
//        assertEquals(2, calc.subtract(3, 5));
    }

    @Test
    void testMultiplicationPositive() {
        assertEquals(15, calc.multiply(5, 3));
//        assertEquals(10, calc.multiply(5, 3));
    }

    @Test
    void testMultiplicationWithZero() {
        assertEquals(0, calc.multiply(5, 0));
    }

    @Test
    void testMultiplicationNegative() {
        assertEquals(-15, calc.multiply(-5, 3));
    }

    @Test
    void testDivisionExact() {
        assertEquals(2, calc.divide(10, 5));
    }

    @Test
    void testDivisionIntegerDivision() {
        assertEquals(2, calc.divide(5, 2)); // 5/2 = 2 in integer division
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    void testPowerPositiveExponent() {
        assertEquals(8, calc.power(2, 3));
    }

    @Test
    void testPowerZeroExponent() {
        assertEquals(1, calc.power(5, 0));
    }

    @Test
    void testPowerZeroBase() {
        assertEquals(0, calc.power(0, 5));
    }

    @Test
    void testPowerNegativeExponent() {
        assertThrows(IllegalArgumentException.class, () -> calc.power(2, -2));
    }

    @Test
    void testSqrtPerfectSquare() {
        assertEquals(4, calc.sqrt(16));
    }

    @Test
    void testSqrtZero() {
        assertEquals(0, calc.sqrt(0));
    }

    @Test
    void testSqrtNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.sqrt(-4));
    }

    @Test
    void testSqrtNotPerfectSquare() {
        assertThrows(IllegalArgumentException.class, () -> calc.sqrt(10));
    }
}

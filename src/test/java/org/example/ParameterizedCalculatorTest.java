package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedCalculatorTest {

    Calculator calc = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "4,2",
            "9,3",
            "25,5"
    })
    void testSquareRoot(int input, int expected) {
        assertEquals(expected, calc.sqrt(input));
    }

}

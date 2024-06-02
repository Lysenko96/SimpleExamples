package org.example.junitmockitoproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addTest() {
        int result = calculator.add(1, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    void isEvenOrOddTest() {
        boolean isEvenBy2 = calculator.isEvenOrOdd(2);
        boolean isEvenBy1 = calculator.isEvenOrOdd(1);
        Assertions.assertTrue(isEvenBy2);
        Assertions.assertFalse(isEvenBy1);
    }

    @Test
    void divideByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}

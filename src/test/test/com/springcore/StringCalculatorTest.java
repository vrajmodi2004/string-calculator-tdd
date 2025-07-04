package com.springcore;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void return_zero_for_empty_string() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void return_number_when_single_number_provided() {
        assertEquals(1, calculator.add("1"));
        assertEquals(7, calculator.add("7"));
    }

}

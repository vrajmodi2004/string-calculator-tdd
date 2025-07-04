package com.springcore;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void return_zero_for_empty_string() {
        assertEquals(0, calculator.add(""));
    }

}

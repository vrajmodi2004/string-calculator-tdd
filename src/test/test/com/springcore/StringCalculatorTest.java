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

    @Test
    public void two_number_string_should_return_sum_of_two(){
        assertEquals(3,calculator.add("1,2"));
        assertEquals(10, calculator.add("6,4"));
    }

    @Test
    public void multiple_numbers_string_should_return_sum_of_all(){
        assertEquals(8,calculator.add("1,2,5"));
        assertEquals(10, calculator.add("6,2,2"));
    }

    @Test
    public void string_with_parenthesis_should_return_sum_of_all(){
        assertEquals(6,calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

}

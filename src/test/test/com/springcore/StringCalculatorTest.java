package com.springcore;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void string_with_different_delimiters_should_return_sum_of_all(){
        assertEquals(8, calculator.add("//-\n3-5"));
        assertEquals(6, calculator.add("//|\n1|2|3"));
    }

    @Test
    public void show_error_for_negative_numbers(){
        StringCalculator calculator = new StringCalculator();

        try {
            calculator.add("1,-2,3");
            fail("Exception expected for negative numbers");
        } catch (IllegalArgumentException ex) {
            assertEquals("negative numbers not allowed: -2", ex.getMessage());
        }

        try {
            calculator.add("-1,-2,3,-4");
            fail("Exception expected for multiple negative numbers");
        } catch (IllegalArgumentException ex) {
            assertEquals("negative numbers not allowed: -1, -2, -4", ex.getMessage());
        }
    }

    @Test
    public void ignore_numbers_greater_than_1000() {
        assertEquals(1002, calculator.add("2,1000"));
        assertEquals(2, calculator.add("//;\n2;1001;1002;10000"));
    }

    @Test
    public void testDelimiterOfAnyLength() {
        int result = calculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }


}

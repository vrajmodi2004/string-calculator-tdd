package com.springcore;

/**
 * Hello world!
 *
 */
public class StringCalculator
{
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers.trim());
    }

}

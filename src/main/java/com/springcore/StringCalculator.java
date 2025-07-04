package com.springcore;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class StringCalculator
{
    public int add(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return 0;
        }

        if (!numbers.contains(",")) {
            return Integer.parseInt(numbers.trim());
        }

        return Arrays.stream(numbers.split(",|\n"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}

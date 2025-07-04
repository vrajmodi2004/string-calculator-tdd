package com.springcore;

import java.util.Arrays;
import java.util.regex.Pattern;

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

        String delimiter = ",|\n";  // Default: comma or newline
        String numString = numbers;

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            // Escape custom delimiter to handle regex special chars
            delimiter = Pattern.quote(parts[0].substring(2));
            numString = parts[1];
        }

        return Arrays.stream(numString.split(delimiter))
                .map(String::trim)
                .filter(s -> !s.isEmpty())   // Defensive: skip empty strings
                .mapToInt(Integer::parseInt)
                .sum();
    }

}

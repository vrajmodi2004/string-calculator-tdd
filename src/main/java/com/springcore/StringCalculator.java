package com.springcore;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        String delimiter = ",|\n";
        String numString = numbers;

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = Pattern.quote(parts[0].substring(2));
            numString = parts[1];
        }

        List<Integer> nums = Arrays.stream(numString.split(delimiter))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> negatives = nums.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            String message = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("negative numbers not allowed: " + message);
        }

        return nums.stream()
                .filter(n -> n <= 1000)
                .mapToInt(Integer::intValue)
                .sum();
    }

}

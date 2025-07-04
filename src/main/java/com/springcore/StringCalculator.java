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

        String delimiter = ",|\n"; // default delimiters
        String numString = numbers;

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiterPart = parts[0].substring(2);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // Supports multiple delimiters like //[***][%%]
                List<String> delimiters = new java.util.ArrayList<>();
                java.util.regex.Matcher m = java.util.regex.Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart);
            }

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

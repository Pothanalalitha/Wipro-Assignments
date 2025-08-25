package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyMapper 
{
	public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob", "Alice");

        Map<String, Long> frequency = names.stream()
                                           .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(frequency);
    }
}

package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;

public class ANameFinder
{
	public static void main(String[] args)
	{
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Anita");

        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}

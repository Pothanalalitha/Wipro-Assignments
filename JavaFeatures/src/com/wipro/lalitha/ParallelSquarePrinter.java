package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;

public class ParallelSquarePrinter 
{
	public static void main(String[] args) 
	{
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.parallelStream()
               .forEach(n -> System.out.println("Square of " + n + " = " + (n * n)));
    }
}

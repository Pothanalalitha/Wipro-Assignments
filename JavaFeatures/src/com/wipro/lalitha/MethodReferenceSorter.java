package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceSorter
{
	public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "David");

        names.sort(String::compareTo);

        System.out.println("Sorted Names: " + names);
    }
}

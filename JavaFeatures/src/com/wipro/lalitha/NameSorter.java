package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;

public class NameSorter 
{
	public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "David", "Charlie");

 
        names.sort((n1, n2) -> n1.compareTo(n2));

        System.out.println("Sorted Names: " + names);
    }
}

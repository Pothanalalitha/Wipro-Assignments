package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;

public class WordCounter 
{
	 public static void main(String[] args) 
	 {
	        List<String> names = Arrays.asList("John", "Alexander", "Chris", "David", "Matthew");

	        long count = names.stream()
	                          .filter(name -> name.length() > 5)
	                          .count();

	        System.out.println("Names longer than 5 characters: " + count);
	    }
}

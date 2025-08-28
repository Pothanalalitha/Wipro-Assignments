package com.wipro.lalitha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrettyJoiner 
{
	public static void main(String[] args) 
	{
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Chennai", "Kolkata");

        String result = cities.stream()
                              .collect(Collectors.joining(", "));

        System.out.println("Joined Cities: " + result);
    }
}

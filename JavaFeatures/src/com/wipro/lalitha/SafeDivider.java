package com.wipro.lalitha;

import java.util.Optional;

public class SafeDivider
{
	public static Optional<Integer> divide(int a, int b)
	{
        if (b == 0) 
        {
            return Optional.empty(); 
        } else 
        {
            return Optional.of(a / b);
        }
    }

    public static void main(String[] args) {
        Optional<Integer> result = divide(10, 2);
        System.out.println(result.orElse(-1));

        Optional<Integer> result2 = divide(10, 0);
        System.out.println(result2.isPresent() ? result2.get() : "Not Allowed");
    }
}

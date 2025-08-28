package com.wipro.lalitha;


interface Calculator {
    int add(int a, int b);

    default int multiply(int a, int b) {
        return a * b;
    }
}
public class DefaultPower implements Calculator
{
	public int add(int a, int b) 
	{
        return a + b;
    }

    public static void main(String[] args) 
    {
        DefaultPower calc = new DefaultPower();
        System.out.println("Addition: " + calc.add(5, 3));
        System.out.println("Multiplication: " + calc.multiply(5, 3));
    }
}

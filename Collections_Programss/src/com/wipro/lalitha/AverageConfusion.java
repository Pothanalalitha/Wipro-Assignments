package com.wipro.lalitha;

public class AverageConfusion 
{
	public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 3};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 10) {
                numbers[i] = numbers[i] * 2; 
            }
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;
        System.out.println("Average = " + average);
    }
}

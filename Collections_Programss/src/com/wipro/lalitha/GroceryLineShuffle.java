package com.wipro.lalitha;

import java.util.ArrayDeque;

public class GroceryLineShuffle
{
	 public static void main(String[] args) {
	        ArrayDeque<String> queue = new ArrayDeque<>();

	        String[] customers = {"John", "Alice", "Bob", "David"};

	        for (String name : customers) {
	            if (name.length() % 2 == 0) {
	                queue.addFirst(name); 
	            } else {
	                queue.addLast(name);  
	            }
	        }

	        System.out.println("Queue Order: " + queue);
	    }
}

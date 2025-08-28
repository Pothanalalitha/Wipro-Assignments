package com.wipro.lalitha;

import java.util.LinkedList;

public class ReversedTaskQueue 
{
	 public static void main(String[] args) {
	        LinkedList<String> tasks = new LinkedList<>();

	        tasks.add("WriteL");   
	        tasks.add("Read");     
	        tasks.add("PlayL");    
	        tasks.add("Sleep");    

	        LinkedList<String> finalList = new LinkedList<>();
	        for (String task : tasks) {
	            if (task.endsWith("L")) {
	                finalList.addFirst(task);
	            } else {
	                finalList.addLast(task);
	            }
	        }

	        System.out.println("Reversed Task Queue: " + finalList);
	    }
}

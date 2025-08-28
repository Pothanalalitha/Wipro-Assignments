package com.wipro.lalitha;

import java.util.LinkedList;

public class RecentAppMemory 
{
	 public static void main(String[] args) {
	        LinkedList<String> apps = new LinkedList<>();

	        String[] opened = {"WhatsApp", "Chrome", "YouTube", "Chrome", "Instagram"};

	        for (String app : opened) {
	            apps.remove(app);  
	            apps.addFirst(app); 
	        }

	        System.out.println("Recent Apps: " + apps);
	    }
}

package com.wipro.lalitha;

import java.util.ArrayDeque;

public class Last3Searches
{
	public static void main(String[] args) {
        ArrayDeque<String> searches = new ArrayDeque<>();

        String[] inputs = {"Java", "Spring", "Microservices", "Hibernate"};
        for (String term : inputs) {
            if (searches.size() == 3) {
                searches.removeFirst(); 
            }
            searches.addLast(term);
        }

        System.out.println("Last 3 Searches: " + searches);
    }
}

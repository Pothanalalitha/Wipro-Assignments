package com.wipro.lalitha;

import java.util.ArrayDeque;

public class LimitedChatHistory 
{
	public static void main(String[] args) {
        ArrayDeque<String> chat = new ArrayDeque<>();

        String[] messages = {"Hi", "How are you?", "Fine", "Good", "See you"};

        for (String msg : messages) {
            if (chat.size() == 4) {
                chat.removeFirst(); 
            }
            chat.addLast(msg);
        }

        System.out.println("Chat History: " + chat);
    }

} 

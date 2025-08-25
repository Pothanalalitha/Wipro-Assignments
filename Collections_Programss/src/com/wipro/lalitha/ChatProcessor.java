package com.wipro.lalitha;

import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor 
{
	public static void main(String[] args) {
        LinkedBlockingQueue<String> messages = new LinkedBlockingQueue<>(5);

        
        new Thread(() -> {
            try {
                for (int i = 1; i <= 7; i++) {
                    messages.put("Message " + i);
                    System.out.println("Added: Message " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        
        new Thread(() -> {
            try {
                while (true) {
                    String msg = messages.take();
                    System.out.println("Processed: " + msg);
                    Thread.sleep(500); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

package com.wipro.lalitha;

import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager 
{
	public static void main(String[] args) {
        ArrayBlockingQueue<String> printerQueue = new ArrayBlockingQueue<>(3);

        String[] jobs = {"Doc1", "Doc2", "Doc3", "Doc4"};

        for (String job : jobs) {
            if (!printerQueue.offer(job)) {
                System.out.println("Queue full! Skipping: " + job);
            }
        }

        while (!printerQueue.isEmpty()) {
            System.out.println("Printing: " + printerQueue.poll());
        }
    }
}

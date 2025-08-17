package com.wipro.lalitha;

import java.util.concurrent.LinkedBlockingQueue;

class Task {
    int id;
    Task(int id) { this.id = id; }
    public String toString() { return "Task " + id; }
}
public class StageBasedTaskRunner 
{
	 public static void main(String[] args) throws InterruptedException {
	        LinkedBlockingQueue<Task> stage1 = new LinkedBlockingQueue<>();
	        LinkedBlockingQueue<Task> stage2 = new LinkedBlockingQueue<>();

	        for (int i = 1; i <= 5; i++) {
	            stage1.put(new Task(i));
	        }

	        while (!stage1.isEmpty()) {
	            Task t = stage1.take();
	            if (t.id % 2 == 0) {
	                stage2.put(t); 
	            }
	        }

	        System.out.println("Stage 2 Tasks: " + stage2);
	    }
}

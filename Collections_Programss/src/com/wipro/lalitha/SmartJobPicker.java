package com.wipro.lalitha;

import java.util.PriorityQueue;

class Job {
    String name;
    int urgency;

    Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}
public class SmartJobPicker 
{
	public static void main(String[] args) {
        PriorityQueue<Job> jobs = new PriorityQueue<>(
            (a, b) -> a.urgency == b.urgency ?
                      a.name.length() - b.name.length() : a.urgency - b.urgency);

        jobs.add(new Job("Update", 3));
        jobs.add(new Job("Fix", 1));
        jobs.add(new Job("Deploy", 2));

        while (!jobs.isEmpty()) {
            System.out.println("Next Job: " + jobs.poll());
        }
    }
}

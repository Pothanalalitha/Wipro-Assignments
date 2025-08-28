package com.wipro.lalitha;

import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;
    long timestamp;

    Patient(String name, int severity, long timestamp) {
        this.name = name;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
public class EmergencyPatientTracker 
{
	public static void main(String[] args) {
        PriorityQueue<Patient> patients = new PriorityQueue<>(
            (a, b) -> a.severity == b.severity ?
                      Long.compare(a.timestamp, b.timestamp) : a.severity - b.severity);

        patients.add(new Patient("Alice", 2, System.nanoTime()));
        patients.add(new Patient("Bob", 1, System.nanoTime()));
        patients.add(new Patient("Charlie", 1, System.nanoTime()));

        while (!patients.isEmpty()) {
            System.out.println("Treating: " + patients.poll());
        }
    }
}

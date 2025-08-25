package com.wipro.lalitha;


@FunctionalInterface
interface MessagePrinter
{
    void printMessage(String msg);
}
public class GreetingPrinter
{
	 public static void print(MessagePrinter printer, String msg) 
	 {
	        printer.printMessage(msg);
	    }

	    public static void main(String[] args) 
	    {
	       
	        print(message -> System.out.println("Hello, " + message), "Java 8");
	    }
}

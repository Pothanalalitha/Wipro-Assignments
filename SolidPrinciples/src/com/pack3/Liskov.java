package com.pack3;

interface Engine
{
	void start();
}
 class car implements Engine
 {

	@Override
	public void start() 
	{
		System.out.println("car  Engine is started");
	}
	 
 }
 class train implements Engine
 {

	@Override
	public void start() 
	{
		System.out.println("train Engine is started");
		
	}
	 
 }
 class Process
 {
	 void process(Engine engine)
	 {
		 engine.start();
	 }
 }
public class Liskov 
{
	public static void main(String[] args) {
		new Process().process(new car());
		
	}
  
}

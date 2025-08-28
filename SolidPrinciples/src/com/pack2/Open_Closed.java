package com.pack2;


interface Engine
{
	void start();
}
 class car implements Engine
 {

	@Override
	public void start() 
	{
		System.out.println("car Engine is started");
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
public class Open_Closed 
{
   public static void main(String[] args) 
   {
	  new car().start();
	  new train().start();
   }
}

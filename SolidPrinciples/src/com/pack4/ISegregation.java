package com.pack4;



interface Book
{
	void Readble();
}
interface Write
{
	void Writable();
}
interface Eat
{
	void Eatable();
}
class Humans implements Book,Write,Eat
{

	@Override
	public void Writable() 
	{

        System.out.println("Humans can write");
		
	}

	@Override
	public void Readble() 
	{
		System.out.println("Humans can read");
		
	}

	@Override
	public void Eatable() 
	{
		
		System.out.println("Humans can Eat ");
	}
	
}
class Animals implements Eat
{

	@Override
	public void Eatable() 
	{
		System.out.println("Animals cannot read and write");
		
	}
	
}
public class ISegregation
{
  public static void main(String[] args) 
  {
	 new Humans().Eatable();
	 new Humans().Readble();
	 new Humans().Writable();
	 new Animals().Eatable();
}
}

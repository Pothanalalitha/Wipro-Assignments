package com.wipro.lalitha.monorepo.entity;

public class Response 
{
private int id;
private String userAnswer;
public int getId() 
{
	return id;
}
public void setId(int id) 
{
	this.id = id;
}
public String getUserAnswer()
{
	return userAnswer;
}
public void setUserAnswer(String userAnswer) 
{
	this.userAnswer = userAnswer;
}

public Response() {
	super();
}
public Response(int id, String userAnswer) {
	super();
	this.id = id;
	this.userAnswer = userAnswer;
}

}


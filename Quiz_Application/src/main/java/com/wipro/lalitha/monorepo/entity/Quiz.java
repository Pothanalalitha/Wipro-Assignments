package com.wipro.lalitha.monorepo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String response;
  
  @ManyToMany
  private List<Question> question;

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public String getresponse() {
	return response;
  }

  public void setresponse(String response) {
	this.response = response;
  }

  public List<Question> getQuestion() {
	return question;
  }

  public void setQuestion(List<Question> question) {
	this.question = question;
  }

  public Quiz() {
	super();
  }

  public Quiz(String response, List<Question> question) {
	super();
	this.response = response;
	this.question = question;
  }
  
}

package com.example.demo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class Profile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String address;
  private Date dob;
  private String gender;
  public Long getId() {
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public String getAddress() {
	return address;
  }
  public void setAddress(String address) {
	this.address = address;
  }
  public Date getDob() {
	return dob;
  }
  public void setDob(Date dob) {
	this.dob = dob;
  }
  public String getGender() {
	return gender;
  }
  public void setGender(String gender) {
	this.gender = gender;
  }
  public Profile() {
	super();
  }
  
}

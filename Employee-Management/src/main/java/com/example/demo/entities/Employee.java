package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int employeeId;
	
  private String employeeName;
  private int employeeAge;
  private String employeeAddress;
  public int getEmployeeId() {
	return employeeId;
  }
  public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
  }
  public String getEmployeeName() {
	return employeeName;
  }
  public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
  }
  public int getEmployeeAge() {
	return employeeAge;
  }
  public void setEmployeeAge(int employeeAge) {
	this.employeeAge = employeeAge;
  }
  public String getEmployeeAddress() {
	return employeeAddress;
  }
  public void setEmployeeAddress(String employeeAddress) {
	this.employeeAddress = employeeAddress;
  }
  public Employee() {
	super();
  }
  public Employee(String employeeName, int employeeAge, String employeeAddress) {
	super();
	this.employeeName = employeeName;
	this.employeeAge = employeeAge;
	this.employeeAddress = employeeAddress;
  }
  
}

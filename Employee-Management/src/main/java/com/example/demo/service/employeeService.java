package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;


public interface employeeService 
{

	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Integer id);
	Employee updateEmployee(Employee employee);
	  void deleteEmployee(Integer id);
	}
  

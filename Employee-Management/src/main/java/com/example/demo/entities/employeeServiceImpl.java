package com.example.demo.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.employeeRepository;
import com.example.demo.service.employeeService;

@Service
public class employeeServiceImpl implements employeeService 
{
	@Autowired
  private employeeRepository  employeerepository;

	@Override
	public List<Employee> getAllEmployee() 
	{
		return employeerepository.findAll();
	}
	

	@Override
	public Employee saveEmployee(Employee employee) 
	{
		return employeerepository.save(employee);
		
	}


	@Override
	public Employee getEmployeeById(Integer id) 
	{
		return employeerepository.findById(id).get();
	}


	@Override
	public Employee updateEmployee(Employee employee) 
	{
		return employeerepository.save(employee);
	}


	@Override
	public void deleteEmployee(Integer id) 
	{
		employeerepository.deleteById(id);
		
	}
}

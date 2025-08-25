package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.entities.Employee;

import com.example.demo.service.employeeService;

@Controller
public class employeeController 
{
	@Autowired
 private employeeService employeeservice;
	
	@GetMapping("/employee")
	public String listEmployee(Model model)
	{
		model.addAttribute("employee",employeeservice.getAllEmployee());
		return "employee";
	}
	 @GetMapping("/employee/new")
	  public String CreateStudentsForm(Model model) 
	  {
		 Employee employee=new Employee();
		 model.addAttribute("employee", employee);
		 return "create_employee";
	  }
	 @PostMapping("/employee")
	  public String saveEmployee( @ModelAttribute("employee") Employee employee)
	  {
		 employeeservice.saveEmployee(employee);
		  return "redirect:/employee";
	  }
	 @GetMapping("/employee/edit/{id}")
	  public String editStudentForm(@PathVariable Integer id,Model model)
	  {
		  model.addAttribute("employee",employeeservice.getEmployeeById(id));
		  return "edit_employee";
	  }
	  @PostMapping("/employee/{id}")
	  public String updateStudent(@PathVariable Integer id,@ModelAttribute("student") Employee employee,Model model)
	  {
		  Employee existingemployee=employeeservice.getEmployeeById(id);
		 existingemployee.setEmployeeName(employee.getEmployeeName());
		 existingemployee.setEmployeeAge(employee.getEmployeeAge());
		 existingemployee.setEmployeeAddress(employee.getEmployeeAddress());
		  return "redirect:/employee";
		  
	  }
	  @GetMapping("/employee/delete/{id}")
	  public String deleteStudent(@PathVariable Integer id)
	  {
		  employeeservice.deleteEmployee(id);
		  return "redirect:/employee";
	  }
}

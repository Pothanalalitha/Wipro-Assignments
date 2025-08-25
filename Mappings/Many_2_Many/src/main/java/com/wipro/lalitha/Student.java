package com.wipro.lalitha;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class Student 
{
	 @Id
	    @GeneratedValue
	    private Long id;
	    private String name;

	    @ManyToMany
	    @JoinTable(
	        name = "student_course", // join table
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	    private List<Course> courses;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		public Student() {
			super();
		}

		public Student(String name, List<Course> courses) {
			super();
			this.name = name;
			this.courses = courses;
		}
	    
}

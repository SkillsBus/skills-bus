package com.mkandeel.skillsbus.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ins_name;
	private double salary;
	
	@OneToOne
	@JoinColumn(name = "course_id",nullable = false)
	private Course course;
	
	@OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
	private List<Student> students;
		
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	public double getSalary() {
		return salary;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
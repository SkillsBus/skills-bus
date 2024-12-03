package com.mkandeel.skillsbus.entities;


public class InstructorModel {
	private Integer id;
	private String ins_name;
	private double salary;
	private String course;
	
	public InstructorModel(Integer id,String ins_name, double salary, String course) {
		this.id = id;
		this.ins_name = ins_name;
		this.salary = salary;
		this.course = course;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}

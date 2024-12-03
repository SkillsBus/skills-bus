package com.mkandeel.skillsbus.entities;



public class InstructorBody {
	private Integer id;
	private String ins_name;
	private double salary;
	private int course_id;
	
	public InstructorBody() {}
	
	public InstructorBody(Integer id, String ins_name, double salary, int course_id) {
		super();
		this.id = id;
		this.ins_name = ins_name;
		this.salary = salary;
		this.course_id = course_id;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}

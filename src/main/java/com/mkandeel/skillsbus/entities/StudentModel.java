package com.mkandeel.skillsbus.entities;

public class StudentModel {
	private int id;
	private String name;
	private String code;
	private String instructor;
	private String course;
	private String phone;
	private double paid;
	
	public StudentModel(int id, String name, String code, String instructor, String course, String phone, double paid) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.instructor = instructor;
		this.course = course;
		this.phone = phone;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}
}
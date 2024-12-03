package com.mkandeel.skillsbus.entities;

public class StudentsAllModel {
	private int id;
	private String std_name;
	private String ins_name;
	private String course;
	private String std_code;
	private String phone;
	private double paid;
	
	public StudentsAllModel(int id,String std_name, String ins_name, String course, String std_code, String phone,
			double paid) {
		this.id = id;
		this.std_name = std_name;
		this.ins_name = ins_name;
		this.course = course;
		this.std_code = std_code;
		this.phone = phone;
		this.paid = paid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStd_code() {
		return std_code;
	}
	public void setStd_code(String std_code) {
		this.std_code = std_code;
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

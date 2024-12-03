package com.mkandeel.skillsbus.entities;

public class CourseModel {
	private int id;
	private String course;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CourseModel(int id, String course, double price) {
		super();
		this.id = id;
		this.course = course;
		this.price = price;
	}
}

package com.mkandeel.skillsbus.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String course;
	private double price;
	
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Instructor instructor;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Student> students;
	
	
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
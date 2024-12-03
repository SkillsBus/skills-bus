package com.mkandeel.skillsbus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkandeel.skillsbus.entities.*;
import com.mkandeel.skillsbus.repos.*;

@Service
public class StudentService {
	@Autowired
	private CoursesRepo courseRepo;
	
	@Autowired
	private InstructorRepo instructorRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student addStudent(StudentBody student) {
		Student std = null;
		if(student.getId() != null) {
			std = studentRepo.findById(student.getId()).orElseThrow(
					() -> new IllegalArgumentException("Student not found with ID: " + student.getId()));
		} else {
			std = new Student();
		}
		
		
		Course course = courseRepo.findById(student.getCourse_id())
				.orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + student.getCourse_id()));
		Instructor instructor = instructorRepo.findById(student.getIns_id())
				.orElseThrow(() -> new IllegalArgumentException("Instructor not found with ID: " + student.getIns_id()));
		
		std.setCourses(course);
		std.setInstructor(instructor);
		std.setPaid(student.getPaid());
		std.setPhone(student.getPhone());
		std.setStd_code(student.getStd_code());
		std.setStd_name(student.getStd_name());
		
		return studentRepo.save(std);
	}
	
	public List<String> getAllCodes() {
		return studentRepo.getAllStudentsCodes();
	}
}

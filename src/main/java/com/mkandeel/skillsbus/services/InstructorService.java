package com.mkandeel.skillsbus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkandeel.skillsbus.entities.*;
import com.mkandeel.skillsbus.repos.*;

@Service
public class InstructorService {
	@Autowired
	private CoursesRepo courseRepository;

	@Autowired
	private InstructorRepo instructorRepository;

	public Instructor addInstructor(InstructorBody request) {
		// Create and populate the Instructor entity
		Instructor instructor = null;
		if (request.getId() != null) {
			instructor = instructorRepository.findById(request.getId()).orElseThrow(
					() -> new IllegalArgumentException("Instructor not found with ID: " + request.getId()));
		} else {
			instructor = new Instructor();
		}

		// Retrieve the Course entity based on the course_id
		Course course = courseRepository.findById(request.getCourse_id())
				.orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + request.getCourse_id()));

		instructor.setIns_name(request.getIns_name());
		instructor.setSalary(request.getSalary());
		instructor.setCourse(course); // Associate the Course with the Instructor

		// Save the Instructor entity
		return instructorRepository.save(instructor);
	}
}

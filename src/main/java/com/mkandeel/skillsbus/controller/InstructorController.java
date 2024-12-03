package com.mkandeel.skillsbus.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.mkandeel.skillsbus.entities.*;
import com.mkandeel.skillsbus.repos.CoursesRepo;
import com.mkandeel.skillsbus.repos.InstructorRepo;
import com.mkandeel.skillsbus.services.InstructorService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class InstructorController {
	@Autowired
	private InstructorRepo repo;
	@Autowired
	private CoursesRepo courseRepo;
	@Autowired
	private InstructorService service;

	@GetMapping("/getAllIns")
	public ResponseEntity<List<InstructorModel>> getInstructorData() {
		// Fetching the raw data from the repository
		List<Map<String, Object>> result = repo.getInstructorData();

		// Mapping the result to a list of InstructorResponse objects
		List<InstructorModel> responseList = new ArrayList<>();
		for (Map<String, Object> row : result) {
			int Id = (int) row.get("id");
			String instructorName = (String) row.get("ins_name");
			double salary = (double) row.get("salary");
			String course = (String) row.get("course");

			InstructorModel response = new InstructorModel(Id, instructorName, salary, course);
			responseList.add(response);
		}

		return ResponseEntity.ok(responseList);
	}

	@PostMapping("/addIns")
	public ResponseEntity<?> addInstructor(@RequestBody InstructorBody request) {
		try {
			request.setId(null);
			String course = courseRepo.findById(request.getCourse_id()).get().getCourse();
			double salary = request.getSalary();
			String ins_name = request.getIns_name();
			Instructor ins = service.addInstructor(request);
			Integer id = ins.getId();
			InstructorModel model = new InstructorModel(id, ins_name, salary, course);
			return ResponseEntity.ok(model);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("/updateIns/{id}")
	public ResponseEntity<?> updateInstructor(@PathVariable int id, @RequestBody InstructorBody request) {
		try {
			request.setId(id); // Set ID for update
			String course = courseRepo.findById(request.getCourse_id()).get().getCourse();
			double salary = request.getSalary();
			String ins_name = request.getIns_name();
			InstructorModel model = new InstructorModel(id, ins_name, salary, course);
			service.addInstructor(request);
			return ResponseEntity.ok(model);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping("/deleteIns/{id}")
	public void deleteIns(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

	@GetMapping("/getIns/{id}")
	public ResponseEntity<List<InstructorModel>> getInstructor(@PathVariable("id") int id) {
		// Fetching the raw data from the repository
		List<Map<String, Object>> result = repo.getInstructor(id);

		// Mapping the result to a list of InstructorResponse objects
		List<InstructorModel> responseList = new ArrayList<>();
		for (Map<String, Object> row : result) {
			int Id = (int) row.get("id");
			String instructorName = (String) row.get("ins_name");
			double salary = (double) row.get("salary");
			String course = (String) row.get("course");

			InstructorModel response = new InstructorModel(Id, instructorName, salary, course);
			responseList.add(response);
		}

		return ResponseEntity.ok(responseList);
	}

	@GetMapping("/getInstructorWithCID/{id}")
	public InstructorBody getCID(@PathVariable("id") int id) {
		InstructorBody body = new InstructorBody();
		Object result = repo.getInstructorByCourseID(id);
		if (result != null) {
			Object[] row = (Object[]) result;
//		Instructor instructor = repo.findById(id).get();
			body.setId((int)row[0]);
			body.setCourse_id((int)row[1]);
			body.setIns_name((String)row[2]);
			body.setSalary((double)row[3]);
			return body;
		} else {
			throw new EntityNotFoundException("Instructor not found for course ID: " + id);
		}
	}
}

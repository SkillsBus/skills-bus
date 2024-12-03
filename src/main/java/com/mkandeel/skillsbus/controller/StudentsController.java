package com.mkandeel.skillsbus.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mkandeel.skillsbus.entities.*;
import com.mkandeel.skillsbus.repos.StudentRepo;
import com.mkandeel.skillsbus.services.StudentService;

@RestController
public class StudentsController {
	
	@Autowired 
	private StudentRepo repo;
	@Autowired
	private StudentService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StudentsAllModel>> getAllStd() {
		List<Map<String,Object>> result = repo.getStudents();
		List<StudentsAllModel> responseList = new ArrayList<>();
		for (Map<String, Object> row : result) {
			int id = (int) row.get("id");
			String name = (String) row.get("std_name");
			String ins = (String) row.get("ins_name");
			String course = (String) row.get("course");
			String code = (String) row.get("std_code");
			String phone = (String) row.get("phone");
			double paid = (double) row.get("paid");
			
			StudentsAllModel model = new 
					StudentsAllModel(id,name, ins, course, code, phone, paid);
			responseList.add(model);
		}
		return ResponseEntity.ok(responseList);
	}
	
	@PostMapping("/addStd")
	public ResponseEntity<?> add(@RequestBody StudentBody request) {
        try {
        	request.setId(null);
            Student student = service.addStudent(request);
            
            StudentModel model = new StudentModel(student.getId(), student.getStd_name(),
            		student.getStd_code(), student.getInstructor().getIns_name(),
            		student.getCourses().getCourse(), student.getPhone(), student.getPaid());
            
            return ResponseEntity.ok(model);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/deleteStd/{id}")
	public void deleteStd(@PathVariable("id") int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/updateStd/{id}")
	public ResponseEntity<?> updateStd(@PathVariable("id") int id, @RequestBody StudentBody request) {
        try {
        	request.setId(id);
            Student student = service.addStudent(request);
            StudentModel model = new StudentModel(id, student.getStd_name(),
            		student.getStd_code(), student.getInstructor().getIns_name(),
            		student.getCourses().getCourse(), student.getPhone(), student.getPaid());
            
            return ResponseEntity.ok(model);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	@GetMapping("/studentCodes")
	public List<String> getAllCodes(){
		return service.getAllCodes();
	}
	/*public void updateStd(@RequestBody Student std) {
		repo.save(std);
	}*/
}
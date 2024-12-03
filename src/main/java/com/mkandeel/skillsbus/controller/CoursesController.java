package com.mkandeel.skillsbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.*;
import com.mkandeel.skillsbus.entities.*;
import org.springframework.web.bind.annotation.*;
import com.mkandeel.skillsbus.repos.CoursesRepo;


@RestController
public class CoursesController {
	@Autowired
	private CoursesRepo repo;
	
	@GetMapping("/allCourses")
	public ResponseEntity<List<CourseModel>> getAll() {
		List<Map<String,Object>> result = repo.getAllCourses();
		List<CourseModel> responseList = new ArrayList<>();
		for (Map<String, Object> row : result) {
			int id = (int) row.get("id");
			String course = (String) row.get("course");
			double price = (double) row.get("price");
			
			CourseModel model = new CourseModel(id, course, price);
			responseList.add(model);
		}
		return ResponseEntity.ok(responseList);
	}
	/*public List<Course> getAll() {
		return repo.findAll();
	}*/
	
	@GetMapping("/getOneCourse/{id}")
	public ResponseEntity<CourseModel> getByID(@PathVariable("id") int id) {
		List<Map<String,Object>> result = repo.getCourseData(id);
		CourseModel responseModel = null;
		for (Map<String, Object> row : result) {
			int Id = (int) row.get("id");
			String course = (String) row.get("course");
			double price = (double) row.get("price");
			
			responseModel = new CourseModel(Id, course, price);
		}
		return ResponseEntity.ok(responseModel);
	}
	/*public Course getByID(@PathVariable("id") int id) {
		return repo.findById(id).get();
	}*/
	
	@PostMapping("/addCourse")
	public Course postCourse(@RequestBody Course course) {
		return repo.save(course);
	}
	
	@PutMapping("/editCourse")
	public void updateCourse(@RequestBody Course course) {
		repo.save(course);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCourse(@PathVariable("id") int id) {
		repo.deleteById(id);
	}
}

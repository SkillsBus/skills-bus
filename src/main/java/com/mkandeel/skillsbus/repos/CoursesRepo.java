package com.mkandeel.skillsbus.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkandeel.skillsbus.entities.Course;
import java.util.*;

public interface CoursesRepo extends  JpaRepository<Course, Integer>{
	
	@Query(value = "Select id,course,price from course", nativeQuery = true)
	List<Map<String,Object>> getAllCourses();
	
	@Query(value = "Select id,course,price from course where id = :id", nativeQuery = true)
	List<Map<String,Object>> getCourseData(@Param("id") int id);
}

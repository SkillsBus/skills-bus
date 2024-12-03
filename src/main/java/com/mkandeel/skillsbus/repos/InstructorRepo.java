package com.mkandeel.skillsbus.repos;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkandeel.skillsbus.entities.*;

public interface InstructorRepo extends  JpaRepository<Instructor, Integer> {
	
	@Query(value = "Select instructor.id,instructor.ins_name,instructor.salary, course.course from instructor,course where instructor.course_id = course.id", nativeQuery = true)
	List<Map<String,Object>> getInstructorData();
	
	@Query(value = "Select instructor.id,instructor.ins_name,instructor.salary, course.course from instructor,course where instructor.course_id = course.id and instructor.id= :ins_id", nativeQuery = true)
	List<Map<String,Object>> getInstructor(@Param("ins_id") int id);
	
	@Query(value = "Select id,course_id,ins_name,salary from instructor where course_id = :id",nativeQuery = true)
	Object getInstructorByCourseID(@Param("id") int id);
}

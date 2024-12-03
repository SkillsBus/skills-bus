package com.mkandeel.skillsbus.repos;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkandeel.skillsbus.entities.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value = "Select student.id as id,std_name, ins_name, course, std_code, phone, paid "
			+ "from student,course, instructor where "
			+ "student.course_id = course.id and student.ins_id = instructor.id", nativeQuery = true)
	List<Map<String,Object>> getStudents();
	//StudentsAllModel getStudents();

	@Query(value = "Select student.id as id,std_name, ins_name, course, std_code, phone, paid "
			+ "from student,course, instructor where "
			+ "student.course_id = course.id and student.ins_id = instructor.id "
			+ "and student.ins_id = (Select id from instructor where ins_name= :name)", nativeQuery = true)
	List<Map<String,Object>> getInstructorStudents(@Param("name") String name);
	//StudentsAllModel getInstructorStudents(@Param("name") String name);
	
	@Query(value = "Select std_code from student",nativeQuery = true)
	List<String> getAllStudentsCodes();
}

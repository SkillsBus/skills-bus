package com.mkandeel.skillsbus.repos;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkandeel.skillsbus.entities.*;

public interface UsersRepo extends JpaRepository<User, Integer> {

	@Query(value = "Select account_type from user where username= :name and pass= :password", nativeQuery = true)
	List<Object[]> getAccountTypeLogin(@Param("name") String name, @Param("password") String password);

}

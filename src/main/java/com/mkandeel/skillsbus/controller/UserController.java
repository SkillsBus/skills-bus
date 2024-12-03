package com.mkandeel.skillsbus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkandeel.skillsbus.entities.LoginBody;
import com.mkandeel.skillsbus.entities.LoginResponse;
import com.mkandeel.skillsbus.entities.User;
import com.mkandeel.skillsbus.repos.UsersRepo;

@RestController
public class UserController {
	@Autowired
	private UsersRepo repo;

	@PostMapping("/login")
	public LoginResponse getAccountType(@RequestBody LoginBody body) {
		Object[] result = repo.getAccountTypeLogin(body.getUsername(), body.getPassword()).get(0);
		int accountType = ((Number) result[0]).intValue();
		return new LoginResponse(accountType);
	}
	
	@PostMapping("/register")
	public void register(@RequestBody User user) {
		repo.save(user);
	}
}

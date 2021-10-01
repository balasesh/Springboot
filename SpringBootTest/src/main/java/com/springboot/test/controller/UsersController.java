package com.springboot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.bean.Users;

@RestController
public class UsersController {
	@GetMapping("id/{id}")
	public Users getUser(
			@PathVariable(value = "id") Long id) {
		String url = "https://jsonplaceholder.typicode.com/users";
		return new Users(url).getUserByID(id);
	}
}

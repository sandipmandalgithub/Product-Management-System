package com.jsp.SprongBoot_ProductProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SprongBoot_ProductProject.entity.User;
import com.jsp.SprongBoot_ProductProject.service.UserService;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;

import jakarta.validation.Valid;
@RestController
public class UserController {
	
	public UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>>saveUser(@RequestBody @Valid User user)
	{
		return service.saveUser(user);
	}

}

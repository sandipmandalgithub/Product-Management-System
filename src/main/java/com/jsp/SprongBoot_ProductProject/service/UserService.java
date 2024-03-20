package com.jsp.SprongBoot_ProductProject.service;

import org.springframework.http.ResponseEntity;

import com.jsp.SprongBoot_ProductProject.entity.User;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;
public interface UserService {
	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

}

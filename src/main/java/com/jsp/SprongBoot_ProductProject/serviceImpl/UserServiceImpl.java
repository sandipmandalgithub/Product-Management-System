package com.jsp.SprongBoot_ProductProject.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SprongBoot_ProductProject.dto.UserRequest;
import com.jsp.SprongBoot_ProductProject.entity.User;
import com.jsp.SprongBoot_ProductProject.repository.UserRepository;
import com.jsp.SprongBoot_ProductProject.service.UserService;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService {
	
	public UserRepository repository;
	public ResponseStructure<User>userStructure;
	public UserServiceImpl(UserRepository repository, ResponseStructure<User> userStructure) {
		super();
		this.repository = repository;
		this.userStructure = userStructure;
	}

	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		return ResponseEntity.ok(userStructure.setMessage("User saved Successfully!!")
				.setStatuscode(HttpStatus.OK.value())
				.setData(repository.save(user)));
	}

	//private User mapToUser(UserRequest userRequest,User user)
	//{
	//	user.setUserName(userRequest.getUserName());
	//	user.setUserEmail(userRequest.getUserEmail());
	//	user.setPhoneNo(userRequest.getPhoneNo());
	//	user.setUserPassword(userRequest.getUserPassword());
	//	
	//	return user;
	//}

}

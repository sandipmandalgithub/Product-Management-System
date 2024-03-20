package com.jsp.SprongBoot_ProductProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SprongBoot_ProductProject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

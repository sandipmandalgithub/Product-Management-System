package com.jsp.SprongBoot_ProductProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.SprongBoot_ProductProject.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}

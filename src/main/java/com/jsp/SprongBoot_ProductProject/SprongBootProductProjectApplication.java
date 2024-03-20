package com.jsp.SprongBoot_ProductProject;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.SprongBoot_ProductProject.entity.Product;

@SpringBootApplication
public class SprongBootProductProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprongBootProductProjectApplication.class, args);
		
		//Product product =new Product();
		
//		Product product=null;
//		Optional.of(product).map(p->{
//			System.out.println("Inside Map");
//			return p;
//		}).orElseThrow(()->new RuntimeException());
		
		
		
	}

}

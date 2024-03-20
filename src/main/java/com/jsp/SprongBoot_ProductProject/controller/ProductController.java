package com.jsp.SprongBoot_ProductProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SprongBoot_ProductProject.dto.ProductRequest;
import com.jsp.SprongBoot_ProductProject.entity.Product;
import com.jsp.SprongBoot_ProductProject.repository.ProductRepository;
import com.jsp.SprongBoot_ProductProject.service.ProductService;
import com.jsp.SprongBoot_ProductProject.utility.ErrorStructure;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {
	//@Autowired
	public ProductService service;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	
	
//************************************SAVE OPERATION***************************************************************************
	
	//@PostMapping("/products/addProduct")
	
	@Operation(description = "The End Point is Used To ADD The PRODUCT into the Database",responses = {
			@ApiResponse(responseCode = "200",description = "Product Saved Successfully"),
			@ApiResponse(responseCode = "400",description = "Invalid inputs")
	})
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>>addProduct(@RequestBody ProductRequest productRequest){
		return service.addProduct(productRequest);
		
	}
	
	
	
	
	
	
//***********************************FIND OPERATION***********************************************************************************************
	
	
	//@GetMapping("/products/findProductById/{productId}")
	
	@Operation(description = "The End Point is Used To FIND The PRODUCT Based on ID",responses = {
			@ApiResponse(responseCode = "200",description = "Product Found Successfully By Requested ID"),
			@ApiResponse(responseCode = "404",description = "Product Not Found By Requested ID",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
			
	})
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>>findProductById(@PathVariable int productId)
	{
		return service.findProductById(productId);
	}
	
	
	
	

	
//*******************************************UPDATE OPERATION*************************************************************************************
	
	//@PutMapping("/products/updateByProductId/{productId}")
	
	@Operation(description = "The End Point is Used To UPDATE The PRODUCT Based on ID")
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId( @PathVariable int productId, @RequestBody Product updateProduct)
	{
		return service.updateByProductId(productId, updateProduct);
	}
	
	
	
	
//********************************************DELETE OPERATION*********************************************************************	
	
	//@DeleteMapping("/products/deleteByProductId/{productId}")
	
	@Operation(description = "The End Point is Used To DELETE the PRODUCT Based on ID")
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>>deleteByProductId(@PathVariable int productId)
	{
		return service.deleteByProductId(productId);
	}
	
//***********************************************FIND ALL OPERATION*******************************************************************************************
	
	//@GetMapping("/products/findAllProducts")
	
	@Operation(description = "The End Point is Used To Find All the Products")
	
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>>findAllProducts()
	{
		return service.findAllProducts();
	}
	

}

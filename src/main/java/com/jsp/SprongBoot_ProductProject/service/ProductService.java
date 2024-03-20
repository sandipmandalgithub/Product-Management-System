package com.jsp.SprongBoot_ProductProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.SprongBoot_ProductProject.dto.ProductRequest;
import com.jsp.SprongBoot_ProductProject.entity.Product;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;

public interface ProductService {

	//SAVE OPERATION
	public ResponseEntity<ResponseStructure<Product>>addProduct(ProductRequest productRequest);

	//FIND BY ID OPERATION
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);

	//UPDATE OPERATION
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product updateProduct);

	//DELETE OPERATION
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);

	//FIND ALL OPERATION
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();



}

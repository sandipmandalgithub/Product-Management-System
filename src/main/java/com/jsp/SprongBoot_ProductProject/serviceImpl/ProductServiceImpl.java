package com.jsp.SprongBoot_ProductProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.jsp.SprongBoot_ProductProject.dto.ProductRequest;
import com.jsp.SprongBoot_ProductProject.entity.Product;
import com.jsp.SprongBoot_ProductProject.exception.ProductNotFoundException;
import com.jsp.SprongBoot_ProductProject.repository.ProductRepository;
import com.jsp.SprongBoot_ProductProject.service.ProductService;
import com.jsp.SprongBoot_ProductProject.utility.ResponseStructure;

import jakarta.persistence.Version;
@Service
public class ProductServiceImpl implements ProductService {
	//@Autowired
	public ProductRepository repository;

	public ResponseStructure<Product>responseStructure;
	public ResponseStructure<List<Product>>listResponseStructure;

	public ProductServiceImpl(ProductRepository repository, ResponseStructure<Product> responseStructure,ResponseStructure<List<Product>>listResponseStructure) {
		super();
		this.repository = repository;
		this.responseStructure = responseStructure;
		this.listResponseStructure=listResponseStructure;
	}


//*********************************************SAVE OPERATION**********************************************************************************************************

	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest productRequest) {
		Product product=repository.save(mapToProduct(productRequest,new Product()));
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product Saved Successfully!!")
				.setData(product));


	}

//**************************************************FIND OPERATION******************************************************************************************************************

	//	@Override
	//	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
	//		Optional<Product> optional = repository.findById(productId);
	//		
	//		if(optional.isPresent())
	//		{
	//			Product product = optional.get();
	//			ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();
	//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
	//			responseStructure.setMessage("Product Found Successfully into Database");
	//			responseStructure.setData(product);
	//			
	//		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
	//		}
	//		else {
	//		
	//			throw new ProductNotFoundException("Product Not Found Exception");
	//		}
	//		
	//		
	//	}


	private Product mapToProduct(ProductRequest productRequest, Product product) {
		
		product.setProductName(productRequest.getProductName());
		product.setProductBrand(productRequest.getProductBrand());
		product.setProductPrice(productRequest.getProductPrice());
		return product;
		
		
		
		//return Product.builder().productName(productRequest.getProductName()).build();
		
		
	}


	@Override
	public ResponseEntity<ResponseStructure<Product>>findProductById(int productId)
	{
		return repository.findById(productId).map(product->{

			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage(" Product Found Successfully into Database ")
					.setData(product)
					);
		}).orElseThrow(()->new ProductNotFoundException("Product Not Found Exception"));
	}




//**********************************************UPDATE OPERATION*****************************************************************************************

	//	@Override
	//	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updateProduct) {
	//		
	//		Optional<Product> optional = repository.findById(productId);
	//	if(optional.isPresent())
	//	{
	//		Product product = optional.get();
	//		updateProduct.setProductId(product.getProductId());
	//		Product save = repository.save(updateProduct);
	//	
	//		ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();
	//		responseStructure.setStatuscode(HttpStatus.OK.value());
	//		responseStructure.setMessage("Product Upadted Successfully into the Database");
	//		responseStructure.setData(save);
	//		
	//		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
	//	}
	//	else
	//	{
	//		throw new ProductNotFoundException("Product Not Found Exception");
	//	}
	//		
	//	}


	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updateProduct)
	{
		return repository.findById(productId).map(product->{
			updateProduct.setProductId(product.getProductId());
			Product saveProduct = repository.save(updateProduct);
			

			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage(" Product Found Successfully into Database ")
					.setData(saveProduct)
					);
		}).orElseThrow(()->new ProductNotFoundException("Product Not Found Exception"));

	}






//*********************************************DELETE OPERATION************************************************************************************

	//	@Override
	//	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
	//		Optional<Product> optional = repository.findById(productId);
	//		if(optional.isPresent())
	//		{
	//			Product product = optional.get();
	//			repository.delete(product);
	//			
	//			ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();
	//			responseStructure.setStatuscode(HttpStatus.OK.value());
	//			responseStructure.setMessage("Product Deleted Successfully from the Database");
	//			responseStructure.setData(product);
	//			
	//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
	//			
	//		}
	//		else
	//		{
	//			throw new ProductNotFoundException("Product Not Found Exception");
	//		}
	//		
	//	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) 
	{

		return repository.findById(productId).map(product->{
			repository.delete(product);

			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage(" Product Deleted Successfully into Database ")
					.setData(product)
					);
		}).orElseThrow(()->new ProductNotFoundException("Product Not Found Exception"));

	}





//*********************************************FIND ALL OPERATION*********************************************************************************************************

//	@Override
//	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
//
//		List<Product> products = repository.findAll();
//
//		ResponseStructure<List<Product>>responseStructure=new ResponseStructure<List<Product>>();
//		responseStructure.setStatuscode(HttpStatus.FOUND.value());
//		responseStructure.setMessage("Find All Products Successfully into the Database");
//		responseStructure.setData(products);
//
//		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);
//	}
	
	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		
		return ResponseEntity.ok(listResponseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage(" Product List Found Successfully into Database ")
				.setData(repository.findAll())
				);
	
	}
	


}

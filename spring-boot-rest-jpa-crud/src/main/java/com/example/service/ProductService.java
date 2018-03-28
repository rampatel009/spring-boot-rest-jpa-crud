package com.example.service;

import com.example.entity.Product;
import com.example.jpa.ProductRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements GenericService<Product, String> {
	private final ProductRepository productRepository;
	
	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public String getId(Product entity) {
		return entity.getId();
	}

	@Override
	public CrudRepository<Product, String> getRepository() {
		return this.productRepository;
	}

}

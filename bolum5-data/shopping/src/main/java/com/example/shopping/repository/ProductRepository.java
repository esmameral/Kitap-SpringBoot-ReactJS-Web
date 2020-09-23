package com.example.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.model.Product;
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findAllByDescriptionContainsIgnoreCase(String str);
	
}
 
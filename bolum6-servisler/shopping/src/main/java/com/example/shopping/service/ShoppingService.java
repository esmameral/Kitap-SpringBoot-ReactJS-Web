package com.example.shopping.service;

import java.util.List;

import com.example.shopping.exception.ProductNotFoundException;
import com.example.shopping.model.Product;
import com.example.shopping.model.Review;

public interface ShoppingService {

	public Product createProduct(Product p);

	public Product findById(int id) throws ProductNotFoundException;

	public List<Product> findAllProducts(String keyword);

	public List<Review> getReviewsByProductId(int id);

	public Review addReview(Review review, int productId);
}
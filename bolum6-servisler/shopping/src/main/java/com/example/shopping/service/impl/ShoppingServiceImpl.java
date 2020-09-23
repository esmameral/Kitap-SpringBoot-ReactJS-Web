package com.example.shopping.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.exception.ProductNotFoundException;
import com.example.shopping.model.Product;
import com.example.shopping.model.Review;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ReviewRepository;
import com.example.shopping.service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException   {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
	}

	@Override
	public List<Product> findAllProducts(String keyword) {
		if (keyword == null) {
			return productRepository.findAll();
		} else {
			return productRepository.findAllByDescriptionContainsIgnoreCase(keyword);
		}
	}

	@Override
	public List<Review> getReviewsByProductId(int id) {
		return reviewRepository.getReviewsByProductId(id);
	}

	@Override
	@Transactional
	public Review addReview(Review review, int productId) {
		Product product = productRepository.findById(productId).get();
		review.setProduct(product);
		return reviewRepository.save(review);
	}

}

package com.example.shopping.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.shopping.exception.ProductNotFoundException;
import com.example.shopping.model.Product;
import com.example.shopping.model.Review;
import com.example.shopping.service.ShoppingService;

@RestController
@RequestMapping(value = "/api/products")
public class ShoppingResource {
	@Autowired
	ShoppingService shoppingService;

	@GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAllProducts(@RequestParam(required = false, name = "keyword") String keyword) {
		return shoppingService.findAllProducts(keyword);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") int id) {
		Product product;
		try {
			product = shoppingService.findById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(product);
		} catch (ProductNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}


	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(shoppingService.createProduct(product));
	}


	@GetMapping(value = "/{productId}/reviews")
	public List<Review> getReviewsByProductId(@PathVariable int productId) {
		return shoppingService.getReviewsByProductId(productId);
	}

	@PostMapping(value = "/{productId}/reviews")
	public ResponseEntity<Review> addReview(@RequestBody Review review, @PathVariable int productId) {
		shoppingService.addReview(review, productId);
		return ResponseEntity.status(HttpStatus.CREATED).body(review);
	}
}

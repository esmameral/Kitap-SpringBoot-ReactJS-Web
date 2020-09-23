package com.example.shopping.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.shopping.exception.ProductNotFoundException;
import com.example.shopping.model.Product;
import com.example.shopping.model.Review;
import com.example.shopping.service.ShoppingService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestShoppingService {

	@Autowired
	ShoppingService shoppingService;
	
	
	@Test
	public void testCreateProduct() {
		Product p = new Product();
		p.setName("Kursun Kalem");
		p.setDescription("Mercanlı Kursun Kalem 12'li");
		p.setPrice(8);
		p.setImg("kalem.jpg");
		shoppingService.createProduct(p);
		assertNotNull(p.getId());
	}
	
	@Test
	public void testFindProducts() {
		List<Product> list=shoppingService.findAllProducts(null);
		int countBeforeInsert=list.size();

		List<Product> list2=shoppingService.findAllProducts("kalem");
		int filteredCountBeforeInsert=list2.size();

		Product product1 = new Product();
		product1.setName("Kursun Kalem");
		product1.setDescription("Mercanlı Kursun Kalem 12'li");
		product1.setPrice(8);
		product1.setImg("kalem.jpg");
		shoppingService.createProduct(product1);
		
		
		Product product2 = new Product();
		product2.setName("A4 72 Yaprak Defter 6 adet");
		product2.setDescription("Paket icerisinde 3 cizgili, "
				+ "3 kareli olmak üzere 6 adet defter "
				+ "bulunmaktadir. Kapaklar plastik olup "
				+ "Siyah, Mavi, Kirmizi, Turuncu renkleri "
				+ "mevcuttur.");
		product2.setPrice(49);
		product2.setImg("notebook6.jpg");
		shoppingService.createProduct(product2);
		
		List<Product> listAfterInsert=shoppingService.findAllProducts(null);
		int countAfterInsert=listAfterInsert.size();
		List<Product> list3=shoppingService.findAllProducts("kalem");
		int filteredCountAfterInsert=list3.size();

		assertTrue(countAfterInsert==countBeforeInsert+2);
		assertTrue(filteredCountAfterInsert==filteredCountBeforeInsert+1);
	}
	
	@Test
	public void testFindProductById() throws ProductNotFoundException {
		Product p = new Product();
		p.setName("Kursun Kalem");
		p.setDescription("Mercanlı Kursun Kalem 12'li");
		p.setPrice(8);
		p.setImg("kalem.jpg");
		shoppingService.createProduct(p);
		assertNotNull(p.getId());
		Product newProduct=shoppingService.findById(p.getId());
		assertTrue(p.getId()==newProduct.getId());		
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testFindProductByIdWithWrongId() throws ProductNotFoundException {
		
		Product newProduct=shoppingService.findById(-1);
	}
	
	@Test
	public void testAddReview() {		
		Product product = new Product();
		product.setName("Kursun Kalem");
		product.setDescription("Mercanlı Kursun Kalem 12'li");
		product.setPrice(8);
		product.setImg("kalem.jpg");
		shoppingService.createProduct(product);
		assertTrue(product.getId()>0);
		
		Review review = new Review();
		review.setAuthor("esma meral");
		review.setStars("1");
		review.setText("berbat");
		
		shoppingService.addReview(review, product.getId());
		assertTrue(review.getId()>0);	
	}
	
	
	@Test
	public void testFindReviewsForProduct() {
		Product product = new Product();
		product.setName("Kursun Kalem");
		product.setDescription("Mercanlı Kursun Kalem 12'li");
		product.setPrice(8);
		product.setImg("kalem.jpg");
		shoppingService.createProduct(product);
		assertTrue(product.getId()>0);
		
		Review review = new Review();
		review.setAuthor("esma meral");
		review.setStars("5");
		review.setText("çok güzel");
		review.setProduct(product);
		
		shoppingService.addReview(review, product.getId());
		
		List<Review> list=shoppingService.getReviewsByProductId(product.getId());
		assertTrue(list.size()==1);
	}

}

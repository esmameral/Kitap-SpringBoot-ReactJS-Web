package com.example.shopping.test.repo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.shopping.model.Product;
import com.example.shopping.model.Review;
import com.example.shopping.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestReviewRepository {
	@Autowired
	ReviewRepository repository;

	@Test
	public void testCreateReview() {
		Product p = new Product();
		p.setName("Kursun Kalem");
		p.setDescription("Mercanlı Kursun Kalem 12'li");
		p.setPrice(8);
		p.setImg("kalem.jpg");

		Review review = new Review();
		review.setAuthor("esma meral");
		review.setStars("3");
		review.setText("cok kaliteli degil");
		review.setProduct(p);
		p.getReviews().add(review);
		repository.save(review);
		assertTrue(review.getId() != 0);
		assertTrue(review.getProduct().getId()!=0);
		assertTrue(review.getProduct().getReviews().size()==1);

	}

}

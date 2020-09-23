package com.example.shopping.test.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.shopping.model.Product;
import com.example.shopping.model.Review;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestProductRepository {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ReviewRepository reviewRepository;

	@Test
	public void testCreateProduct() {
		long count = productRepository.count();
		Product p = new Product();
		p.setName("Kursun Kalem");
		p.setDescription("Mercanlı Kursun Kalem 12'li");
		p.setPrice(8);
		p.setImg("kalem.jpg");
		productRepository.save(p);
		assertNotNull(p.getId());
		long newCount = productRepository.count();
		assertTrue(newCount == count + 1);
	}

	@Test
	public void testSearchProduct() {
		// find the number of products which have "plastik" term on its description
		List<Product> list1 = productRepository.findAllByDescriptionContainsIgnoreCase("plastik");
		int count1 = list1.size();
		System.out.println("plastik sayısı:" + count1);

		// find the number of products which have "Cetvel" term on its description
		List<Product> list2 = productRepository.findAllByDescriptionContainsIgnoreCase("cetvel");
		int count2 = list2.size();
		System.out.println("cetvel sayısı:" + count2);

		Product product1 = new Product();
		product1.setName("A4 72 Yaprak Defter 6 adet");
		product1.setDescription("Paket icerisinde 3 cizgili, "
				+ "3 kareli olmak üzere 6 adet defter "
				+ "bulunmaktadir. Kapaklar plastik olup "
				+ "Siyah, Mavi, Kirmizi, Turuncu renkleri "
				+ "mevcuttur.");
		product1.setPrice(49);
		product1.setImg("notebook6.jpg");
		productRepository.save(product1);
		assertTrue(product1.getId()>0);

		Product product2 = new Product();
		product2.setName("Cetvel Genis Plastik Mercekli 30 Cm");
		product2.setDescription("Mercekli Genis Büro Cetveli "
				+ "30 cm boyutundadir.Kaliteli plastikten "
				+ "üretilmistir."
				+ "Üzerindeki mercek, detayli bakmak "
				+ "isteginiz yazilarda size yardimci olacaktir.");
		product2.setPrice(5);
		product2.setImg("cetvel.jpg");
		productRepository.save(product2);
		assertTrue(product2.getId()>0);

		// find the number of products which have "plastik" term on its description
		List<Product> list3 = productRepository.findAllByDescriptionContainsIgnoreCase("plastik");
		assertTrue(list3.size() == count1 + 2);
		
		// find the number of products which have "Cetvel" term on its description
		List<Product> list4 = productRepository.findAllByDescriptionContainsIgnoreCase("ceTveL");
		assertTrue(list4.size() == count2 + 1);
	}
	
	@Test
	public void testCreateProductWithReviews() {
		long count = productRepository.count();
		Product product = new Product();
		product.setName("Dolma Kalem");
		product.setDescription("Tek Kullanımlık Dolma Kalem." + 
				"Renk: Mavi. Mürekkep Miktarı: 2,5 Gram");
		product.setPrice(11);
		product.setImg("pen.jpg");
		assertTrue(product.getId()==0);
		
		Review firstReview=new Review();
		firstReview.setAuthor("esma meral");
		firstReview.setStars("5");
		firstReview.setText("cok guzel tavsiye ederim");
		firstReview.setProduct(product);
		assertTrue(firstReview.getId()==0);
		
		Review secondReview=new Review();
		secondReview.setAuthor("derya demirturk");
		secondReview.setStars("4");
		secondReview.setText("biraz daha ucuz olabilirdi ama guzel");
		secondReview.setProduct(product);
		assertTrue(secondReview.getId()==0);

		product.getReviews().add(firstReview);
		product.getReviews().add(secondReview);
		productRepository.save(product);
		assertTrue(product.getId()>0);
		long newCount = productRepository.count();
		assertTrue(newCount == count + 1);
		
		assertTrue(firstReview.getId()>0);
		assertTrue(secondReview.getId()>0);
		assertTrue(firstReview.getProduct().getId()==product.getId());
		assertTrue(secondReview.getProduct().getId()==product.getId());
	}
}

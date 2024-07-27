package com.rudradcruze.jpaTutorial.jpaTuts;

import com.rudradcruze.jpaTutorial.jpaTuts.entities.Product;
import com.rudradcruze.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		Product productEntity = Product.builder()
				.sku("nestle1234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(12.99))
				.quantity(100)
				.build();
		Product savedProduct = productRepository.save(productEntity);
		System.out.println(savedProduct);
	}

	@Test
	void getByTitle() {
		List<Product> entity = productRepository.findByTitle("Pepsi");
		System.out.println(entity);
	}


	@Test
	void getByCreatedAtAfter() {
		List<Product> entity = productRepository.findByCreatedAtAfter(LocalDateTime.of(2025, 1, 1, 0, 0, 0));
		System.out.println(entity);
	}

	@Test
	void getByQuantityAndPrice() {
		List<Product> entity = productRepository.findByQuantityAndPrice(3, BigDecimal.valueOf(17.40));
		System.out.println(entity);
	}

	@Test
	void getByQuantityGreaterThanAndPriceLessThan() {
		List<Product> entity = productRepository.findByQuantityGreaterThanAndPriceLessThan(2, BigDecimal.valueOf(20));
		System.out.println(entity);
	}

	@Test
	void getByQuantityGreaterThanOrPriceLessThan() {
		List<Product> entity = productRepository.findByQuantityGreaterThanOrPriceLessThan(2, BigDecimal.valueOf(20));
		System.out.println(entity);
	}

	@Test
	void getProductsByTitleLike() {
		List<Product> entity = productRepository.findProductsByTitleLike("%Co%");
		System.out.println(entity);
	}

	@Test
	void getProductsByTitleContaining() {
		List<Product> entity = productRepository.findProductsByTitleContaining("Co");
		System.out.println(entity);
	}

	@Test
	void getProductsByTitleContainingIgnoreCase() {
		List<Product> entity = productRepository.findProductsByTitleContainingIgnoreCase("Co");
		System.out.println(entity);
	}

	@Test
	void getSingleFromRepository() {
		Optional<Product> entity = productRepository
				.findProductByTitleAndPrice(
						"Pepsi",
						BigDecimal.valueOf(14.40));
		entity.ifPresent(System.out::println);
	}

	@Test
	void getSingleFromRepositoryJPQL() {
		Optional<Product> entity = productRepository
				.findProductByTitleAndPriceJPQL(
						"Pepsi",
						BigDecimal.valueOf(14.40));
		entity.ifPresent(System.out::println);
	}

	@Test
	void getSingleFromRepositoryJPQL2() {
		Optional<Product> entity = productRepository
				.findProductByTitleAndPriceJPQL2(
						"Pepsi",
						BigDecimal.valueOf(14.40));
		entity.ifPresent(System.out::println);
	}

}

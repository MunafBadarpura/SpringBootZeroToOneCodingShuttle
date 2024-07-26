package com.rudradcruze.jpaTutorial.jpaTuts.repositories;

import com.rudradcruze.jpaTutorial.jpaTuts.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBy(Sort sort);

//    List<Product> findByTitle(String title);

    List<Product> findByTitle(String title);

    List<Product> findByTitle(String title, Pageable pageable);

    List<Product> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Product> findByCreatedAtAfter(LocalDateTime createdAt);

    List<Product> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<Product> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<Product> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<Product> findProductsByTitleLike(String title);

    List<Product> findProductsByTitleContaining(String title);

    List<Product> findProductsByTitleContainingIgnoreCase(String title);

    Optional<Product> findProductByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from Product p where p.title = :title and p.price = :price")
    Optional<Product> findProductByTitleAndPriceJPQL(String title, BigDecimal price);

    @Query("select p from Product p where p.title = ?1 and p.price = ?2")
    Optional<Product> findProductByTitleAndPriceJPQL2(String title, BigDecimal price);
}

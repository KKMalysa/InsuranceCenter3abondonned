package com.karolmalysa.insurancecenter.model.dao;

import com.karolmalysa.insurancecenter.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetween(float minPrice, float maxPrice);
}

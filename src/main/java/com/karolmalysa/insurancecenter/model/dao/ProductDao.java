package com.karolmalysa.insurancecenter.model.dao;

import com.karolmalysa.insurancecenter.model.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ProductDao {


    @PersistenceContext
    private EntityManager entityManager;

    //saving into db
    @Transactional
    public Product save(Product product){
        entityManager.persist(product);
        log.info("Product [{ }] added to database", product.getId());
        return  product;
    }

    public List<Product> findAll() {
        Query namedQuery = entityManager.createNamedQuery("Product.findAll");
        List<Product> resultList = namedQuery.getResultList();
        log.info("Got {} products", resultList.size());

        return resultList;
    }
    public List<Product> findByPriceBetween(float minPrice, float maxPrice) {
        Query namedQuery = entityManager.createNamedQuery("Product.findByPriceBetween");
        namedQuery.setParameter("minPrice", minPrice);
        namedQuery.setParameter("maxPrice", maxPrice);
        List<Product> resultList = namedQuery.getResultList();
        log.info("Got {} products with price between {} and {}", resultList.size(), minPrice, maxPrice);

        return resultList;
    }

}

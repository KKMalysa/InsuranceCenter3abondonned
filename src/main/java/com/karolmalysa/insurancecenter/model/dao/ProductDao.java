package com.karolmalysa.insurancecenter.model.dao;

import com.karolmalysa.insurancecenter.model.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {


    @PersistenceContext
    private EntityManager entityManager;

    //saving into db
    @Transactional
    public Product save(Product product){
        entityManager.persist(product);
        return  product;
    }

}

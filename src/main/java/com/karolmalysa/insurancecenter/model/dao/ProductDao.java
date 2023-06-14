package com.karolmalysa.insurancecenter.model.dao;

import com.karolmalysa.insurancecenter.model.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {


    @PersistenceContext
    private EntityManager entityManager;

    //zapis produktu w bazie danych
    public Product save(Product product){
        entityManager.persist(product);
        return  product;
    }

}

package com.karolmalysa.insurancecenter.model.components;

import com.karolmalysa.insurancecenter.model.dao.ProductDao;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import com.karolmalysa.insurancecenter.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductComponnent {

    private final ProductDao productDao;

    @Autowired
    public ProductComponnent(ProductDao productDao) {
        this.productDao = productDao;
    }


    public ProductDto saveProduct (ProductDto productDto) {
        Product product = productDao.save(productDto.createEntity());

        return new ProductDto(product);
    }






}

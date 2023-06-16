package com.karolmalysa.insurancecenter.model.components;

import com.karolmalysa.insurancecenter.model.dao.ProductDao;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import com.karolmalysa.insurancecenter.model.entities.Product;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
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


    public List<ProductDto> findAll () {
        return productDao.findAll().stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());


    }
    public List<ProductDto> findByPriceBetween (Long minPrice, Long maxPrice ) {
        return productDao.findByPriceBetween (minPrice.floatValue(),maxPrice.floatValue() ).stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());


    }





}

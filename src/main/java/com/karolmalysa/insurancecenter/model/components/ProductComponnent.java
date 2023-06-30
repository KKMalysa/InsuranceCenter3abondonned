package com.karolmalysa.insurancecenter.model.components;

import  com.karolmalysa.insurancecenter.model.dao.ProductRepository;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import com.karolmalysa.insurancecenter.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductComponnent {

    private final ProductRepository productRepository;


    public ProductDto saveProduct (ProductDto productDto) {
        Product product = productRepository.save(productDto.createEntity());

        return new ProductDto(product);
    }


    public List<ProductDto> findAll () {
        return productRepository.findAll().stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());

    }

    /** pagination */
    public List<ProductDto> findAll (Integer pageNumber, Integer pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());

    }

    public List<ProductDto> findByPriceBetween (Long minPrice, Long maxPrice ) {
        return productRepository.findByPriceBetween (minPrice.floatValue(),maxPrice.floatValue() ).stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());


    }





}

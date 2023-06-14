package com.karolmalysa.insurancecenter.model.dto;

import com.karolmalysa.insurancecenter.model.entities.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDto {


    private Long id;

    private  String name;

    private Long amount = 1L;

    private  Float price; //BigDecimal?


    public Product createEntity() {

        Product product = new Product();

        product.setName(this.name);
        product.setAmount(this.amount);
        product.setPrice(this.price);

        return product;
    }

    public  ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.amount = product.getAmount();
       this.price = product.getPrice();
    }
}
